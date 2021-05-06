package com.bandwith.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.copyOf;

public class AudioService {
    public static InputStream mixAudioFiles (List<String> fileUrls) throws IOException {
        InputStream[] isList = new InputStream[fileUrls.size()];
        byte[] output;
        ArrayList<byte[]> byteBuffers = new ArrayList<>();

        try {
            // get InputStream from URL
            // convert InputStream to byte[]
            for (int i = 0; i < isList.length; i++) {
                isList[i] = new URL(fileUrls.get(i)).openStream();
                byteBuffers.add(IOUtils.toByteArray(isList[i]));
            }
            output = mixBuffers(byteBuffers);
            // FileUtils.writeByteArrayToFile(new File("path"), output);
        }
        catch(Exception e){
            throw(e);
        }
        finally {
            for (InputStream is : isList) {
                is.close();
            }
        }

        return new ByteArrayInputStream(output);
    }

    private static byte[] mixBuffers(ArrayList<byte[]> sources) {
        final int HEADER_LENGTH = 104;
        int maxLength = -1;
        int maxIndex = 0, index = 0;
        int sourceSize = sources.size();

        for(byte[] source: sources){
            if(source.length > maxLength) {
                maxLength = source.length;
                maxIndex = index;
            }
            index++;
        }

        ArrayList<byte[]> sourcesSameLength = new ArrayList<>();

        // set all byte stream's length to max length
        for(byte[] source: sources){
            sourcesSameLength.add(copyOf(source, maxLength));
        }

        byte[] result = new byte[maxLength];

        // copy wav file header
        for(int i=0; i<HEADER_LENGTH; i++){
            result[i] = sourcesSameLength.get(maxIndex)[i];
        }

        // mix wav files
        for (int i=HEADER_LENGTH; i<maxLength; i++) {
            byte sum = 0;
            for (byte[] source: sourcesSameLength){
                sum += (byte)(source[i]/sourceSize);
            }
            result[i] = sum;
        }

        return result;
    }
}



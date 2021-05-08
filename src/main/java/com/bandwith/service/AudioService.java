package com.bandwith.service;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.copyOf;

public class AudioService {
    // 오디오 파일 합치기
    public static byte[] mixAudioFiles(List<String> fileUrls) throws IOException {
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
        } catch (Exception e) {
            throw (e);
        } finally {
            for (InputStream is : isList) {
                is.close();
            }
        }

        return output;
    }

    private static byte[] mixBuffers(ArrayList<byte[]> sources) {
        final int HEADER_LENGTH = 104;
        int maxLength = -1;
        int maxIndex = 0, index = 0;
        int sourceSize = sources.size();

        for (byte[] source : sources) {
            if (source.length > maxLength) {
                maxLength = source.length;
                maxIndex = index;
            }
            index++;
        }

        ArrayList<byte[]> sourcesSameLength = new ArrayList<>();

        // set all byte stream's length to max length
        for (byte[] source : sources) {
            sourcesSameLength.add(copyOf(source, maxLength));
        }

        byte[] result = new byte[maxLength];

        // copy wav file header
        for (int i = 0; i < HEADER_LENGTH; i++) {
            result[i] = sourcesSameLength.get(maxIndex)[i];
        }

        // mix wav files
        for (int i = HEADER_LENGTH; i < maxLength; i++) {
            byte sum = 0;
            for (byte[] source : sourcesSameLength) {
                sum += (byte) (source[i] / sourceSize);
            }
            result[i] = sum;
        }

        return result;
    }

    // 잡음 제거
    public static void denoiser(String path, String fileName) throws IOException, InterruptedException {
        String[] args = new String[6];
        args[0] = "python";
        args[1] = "C:/band-with/wavelet-denoiser/src/denoiser-argument.py";    // 수행할 코드의 위치
        args[2] = "-i";
        args[3] = path + fileName;                  // input file
        args[4] = "-o";
        args[5] = path + "denoise-" + fileName;     // output file

        buildProcess(args);
        System.out.println("finish denoise");
    }

    private static void buildProcess(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(args[0], args[1], args[2], args[3], args[4], args[5]);
        Process p = pb.start();

//        // 파이썬에서 출력된 내용 출력
//        char[] readBuffer = new char[1000];
//        InputStreamReader isr = new InputStreamReader(p.getInputStream());
//        BufferedReader br = new BufferedReader(isr);
//
//        while (true) {
//            int n = br.read(readBuffer);
//            if (n <= 0)
//                break;
//            System.out.print(new String(readBuffer, 0, n));
//        }

        p.waitFor();
        p.destroy();
    }

    public static void downloadFile(String path, MultipartFile file) throws IOException {
        FileOutputStream fos = new FileOutputStream(path + file.getOriginalFilename());
        InputStream is = file.getInputStream();

        int readCount;
        byte[] buffer = new byte[1024];

        while ((readCount = is.read(buffer)) != -1) {
            fos.write(buffer, 0, readCount);
        }
    }
}



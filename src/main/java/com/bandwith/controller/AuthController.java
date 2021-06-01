package com.bandwith.controller;

import com.bandwith.dto.member.MemberDto;
import com.bandwith.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
public class AuthController {
    private MemberService memberService;
    private HttpSession session;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(@Qualifier("memberServiceBean") MemberService memberService,
                          PasswordEncoder passwordEncoder){
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/auth/rsa", method = RequestMethod.GET)
    public List<String> mainLogout(HttpSession session, HttpServletResponse response ) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        if(this.session == null)
            this.session = session;

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        List<String> publicKeyList = new ArrayList<>();
        PublicKey publicKey;

        if(this.session.getAttribute("RSA_PUBLIC_KEY") != null) {
            publicKey = (PublicKey) this.session.getAttribute("RSA_PUBLIC_KEY");
        }
	    else {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(1024);
            KeyPair keyPair = generator.genKeyPair();
            publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            this.session.setAttribute("RSA_PRIVATE_KEY", privateKey);   //세션에 RSA 개인키를 세션에 저장한다.
            this.session.setAttribute("RSA_PUBLIC_KEY", publicKey);
        }
        RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
        String publicKeyModulus = publicSpec.getModulus().toString(16);
        String publicKeyExponent = publicSpec.getPublicExponent().toString(16);

        publicKeyList.add(publicKeyModulus);
        publicKeyList.add(publicKeyExponent);

        return publicKeyList;
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<String> signUp(@RequestBody String filterJSON) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        MemberDto newMember = mapper.readValue(filterJSON, MemberDto.class);
        String rawPwd;

        rawPwd = newMember.getPwd();
        newMember.setPwd(passwordEncoder.encode(rawPwd));

        memberService.signUp(newMember);
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }


    public String decryptRsa(PrivateKey privateKey, String securedValue) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException {
        String decryptedValue = "";

        Cipher cipher = Cipher.getInstance("RSA");

        byte[] encryptedBytes = hexToByteArray(securedValue);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        decryptedValue = new String(decryptedBytes, "utf-8");

        return decryptedValue;
    }

    public static byte[] hexToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }


    @PostMapping("/auth/signin")
    public ResponseEntity<MemberDto> signIn(@RequestBody String filterJSON) throws JsonProcessingException, NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        ObjectMapper mapper = new ObjectMapper();
        MemberDto memberDto = mapper.readValue(filterJSON, MemberDto.class);


        String uid = memberDto.getUsername();
        String pwd = memberDto.getPwd();

        PrivateKey privateKey = (PrivateKey) this.session.getAttribute("RSA_PRIVATE_KEY");
        //암호화처리된 사용자계정정보를 복호화 처리한다.
        String _uid = decryptRsa(privateKey, uid);
        String _pwd = decryptRsa(privateKey, pwd);

        memberDto.setUsername(_uid);
        memberDto.setPwd(_pwd);

        System.out.println(passwordEncoder.encode(_pwd));

        MemberDto loginMember = memberService.signIn(memberDto);

        if(loginMember == null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(loginMember);
    }

    @PostMapping("/auth/getCode")
    @ResponseBody
    public ResponseEntity<?> sendCode(@RequestBody JSONObject filterJSON, HttpSession session) {
        if(this.session == null)
            this.session = session;
        String mail = (String)filterJSON.get("mail");
        memberService.sendMail(mail, this.session);

        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @PostMapping("/auth/checkCode")
    @ResponseBody
    public ResponseEntity<?> checkCode(@RequestBody JSONObject filterJSON){
        HttpSession session = this.session;

        String mail = (String)filterJSON.get("mail");
        String code = (String)filterJSON.get("code");

        if(memberService.checkCode(mail, code, session))
            return ResponseEntity.status(HttpStatus.OK).body("");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("");
    }
}

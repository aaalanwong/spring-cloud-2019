package com.atguigu.common.util;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AesCrypto {

    private static final String ALGORIHM = "AES";
    private static final Integer KYE_GENERATOR_LENGTH = 128;
    private static final String SECURE_RANDOM_INSTANCE = "SHA1PRNG";

    public static String encrypt(String content, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecureRandom secureRandom = SecureRandom.getInstance(SECURE_RANDOM_INSTANCE);
        secureRandom.setSeed(password.getBytes(CryptoUtil.DEFAULT_ENCODEING));
        KeyGenerator keygen = KeyGenerator.getInstance(ALGORIHM);
        keygen.init(KYE_GENERATOR_LENGTH, secureRandom);
        SecretKey secretKey = keygen.generateKey();
        Cipher cipher = Cipher.getInstance(ALGORIHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte [] result = cipher.doFinal(content.getBytes(CryptoUtil.DEFAULT_ENCODEING));
        return CryptoUtil.byte2hex(result);
    }

    public static String decrypt(String content, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecureRandom secureRandom = SecureRandom.getInstance(SECURE_RANDOM_INSTANCE);
        secureRandom.setSeed(password.getBytes(CryptoUtil.DEFAULT_ENCODEING));
        KeyGenerator keygen = KeyGenerator.getInstance(ALGORIHM);
        keygen.init(KYE_GENERATOR_LENGTH, secureRandom);
        SecretKey secretKey = keygen.generateKey();
        //创建密码器
        Cipher cipher = Cipher.getInstance(ALGORIHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte [] result = cipher.doFinal(CryptoUtil.hex2Byte(content.getBytes(CryptoUtil.DEFAULT_ENCODEING)));

        return new String(result, CryptoUtil.DEFAULT_ENCODEING);
    }

    public static void main(String[] args) throws Exception{
        String content = "{\"content\" : \"你好，黄国庆\"}";
        System.out.println("原文是：" + content);
        String password = "8Jw%g1&jy";
        String miwen = encrypt(content, password);
        System.out.println("密文是：" + miwen);
        String mingwen = decrypt(miwen, password);
        System.out.println("明文是：" + mingwen);
    }
}

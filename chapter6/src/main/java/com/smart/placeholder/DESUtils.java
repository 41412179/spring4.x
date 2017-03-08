package com.smart.placeholder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DESUtils {

    // 1.指定DES加密解密所用的秘钥
    private static Key key;
    private static String KEY_STR = "myKey";

    static {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            generator.init(new SecureRandom(KEY_STR.getBytes()));
            key = generator.generateKey();
            generator = null;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // 2.对字符串进行DES加密，返回BASE64编码的加密字符串
    public static String getEncryptString(String str) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        try {
            byte[] strBytes = str.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptStrBytes = cipher.doFinal(strBytes);
            return base64Encoder.encode(encryptStrBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 3.对BASE64加密字符串进行解密，返回解密后的字符串
    public static String getDecryptStr(String str) {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            byte[] strBytes = base64Decoder.decodeBuffer(str);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptBytes = cipher.doFinal(strBytes);
            return new String(decryptBytes, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 4.对入参的字符串进行加密，打印出加密后的字符串
    public static void main(String[] args) {
//        args = new String[]{"root", "root123"};
        if (args == null || args.length < 1) {
            System.out.println("输入要加密的字符串，用空格分隔");
        } else {
            for (String arg : args) {
                System.out.println(arg + ": " + getEncryptString(arg));
            }
        }
    }
}

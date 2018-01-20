package com.github.wxz.common.crypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author xianzhi.wang
 * @date 2018/1/12 -14:54
 */
public class AesCrypt {
    private static final String AES_TYPE = "AES/ECB/PKCS5Padding";
    private static final char[] ARRAYS = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};


    public static String encode(String secretKey, String plainText) {
        Key key = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = null;

        try {
            cipher = Cipher.getInstance(AES_TYPE);
            cipher.init(1, key);
            byte[] encryptedText = cipher.doFinal(plainText.getBytes());
            return Base64.encodeBase64String(encryptedText);
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }

    public static String decode(String secretKey, String cipherText) {
        Key key = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = null;

        try {
            cipher = Cipher.getInstance(AES_TYPE);
            cipher.init(2, key);
            byte[] originBytes = cipher.doFinal(Base64.decodeBase64(cipherText));
            return new String(originBytes);
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }

    private static Key generateKey(String key) throws Exception {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            return keySpec;
        } catch (Exception var2) {
            var2.printStackTrace();
            throw var2;
        }
    }

    public static String init128Key() {
        StringBuilder stringBuilder = new StringBuilder(17);
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int lengths = 16;
        for (int i = 0; i < lengths; ++i) {
            stringBuilder.append(ARRAYS[threadLocalRandom.nextInt(ARRAYS.length)]);
        }

        return stringBuilder.toString();
    }
}

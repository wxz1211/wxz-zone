package com.github.wxz.framework.netease;

import org.apache.commons.text.RandomStringGenerator;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xianzhi.wang
 * @date 2018/1/26 -13:10
 */
public class NetEaseEncryptUtils {

    private final static String MODULUS = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7" +
            "b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280" +
            "104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932" +
            "575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b" +
            "3ece0462db0a22b8e7";

    private final static String NONCE = "0CoJUm6Qyw8W8jud";
    private final static String PUB_KEY = "010001";

    private static final String PARAMS = "params";
    private static final String ENCSECKEY = "encSecKey";

    public static Map<String, String> encrypt(String text) {
        RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder().withinRange(0,9).withinRange('a','e').build();
        String secKey = randomStringGenerator.generate(20);
        String encText = aesEncrypt(aesEncrypt(text, NONCE), secKey);
        String encSecKey = rsaEncrypt(secKey, PUB_KEY, MODULUS);

        Map<String, String> map = new HashMap<>(1<<4);
        map.put(PARAMS, encText);
        map.put(ENCSECKEY, encSecKey);
        return map;
    }

    private static String aesEncrypt(String text, String key) {
        try {
            IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(text.getBytes());

            return new BASE64Encoder().encode(encrypted);
        } catch (Exception e) {
            return "";
        }
    }

    private static String rsaEncrypt(String text, String pubKey, String modulus) {
        text = new StringBuilder(text).reverse().toString();
        BigInteger rs = new BigInteger(String.format("%x", new BigInteger(1, text.getBytes())), 16)
                .modPow(new BigInteger(pubKey, 16), new BigInteger(modulus, 16));
        String r = rs.toString(16);
        int length = 256;
        if (r.length() >= length) {
            return r.substring(r.length() - 256, r.length());
        } else {
            while (r.length() < length) {
                r = 0 + r;
            }
            return r;
        }
    }
}

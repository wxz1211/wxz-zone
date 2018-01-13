package com.github.wxz.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/**
 * type: class
 *
 * @author xianzhi.wang
 * @see
 * @since JDK 1.8
 */
public class UrlUtils {
    public UrlUtils() {
    }

    public static String build(String url, Map<String, String> params) {
        if (params != null && !params.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(url);
            stringBuilder.append("?");
            Iterator var3 = params.entrySet().iterator();

            while (var3.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry) var3.next();
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append((String) entry.getValue());
                stringBuilder.append("&");
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        } else {
            return url;
        }
    }

    public static String encode(String text) {
        try {
            return URLEncoder.encode(text, "utf-8");
        } catch (UnsupportedEncodingException var2) {
            throw new RuntimeException(var2);
        }
    }

    public static String decode(String text) {
        try {
            return URLDecoder.decode(text, "utf-8");
        } catch (UnsupportedEncodingException var2) {
            throw new RuntimeException(var2);
        }
    }
}

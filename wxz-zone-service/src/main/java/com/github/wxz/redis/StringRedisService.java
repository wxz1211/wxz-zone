package com.github.wxz.redis;

/**
 * @author xianzhi.wang
 * @date 2018/1/12 -15:34
 */
public interface StringRedisService {
    /**
     * getString
     * @param key
     * @return
     */
    String getString(String key);

    /**
     * existsString
     * @param key
     * @return
     */
    boolean existsString(String key);

    /**
     * setString
     * @param key
     * @param value
     */
    void setString(String key, String value);

    /**
     * setString
     * @param key
     * @param value
     * @param expire
     */
    void setString(String key, String value, long expire);

    /**
     * delString
     * @param key
     */
    void delString(String key);
}

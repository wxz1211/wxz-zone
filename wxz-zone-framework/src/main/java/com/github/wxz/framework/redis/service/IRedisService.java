package com.github.wxz.framework.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author xianzhi.wang
 * @date 2018/1/12 -13:10
 */
public abstract class IRedisService<T> {

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    @Resource
    public HashOperations<String, String, T> hashOperations;

    @Resource
    public ValueOperations<String, Object> valueOperations;

    public void set(final String key, String value) {
        set(key, value, -1);
    }

    public void set(final String key, String value, long expire) {
        if (expire == -1) {
            valueOperations.set(key, value);
        } else {
            valueOperations.set(key, value, expire, TimeUnit.SECONDS);
        }
    }

    public String get(final String key) {
        Object object = valueOperations.get(key);
        return object == null ? null : object.toString();
    }

    public boolean exists(final String key) {
        return get(key) == null ? false : true;
    }

    public void del(final String key) {
        redisTemplate.delete(key);
    }


    /**
     * hash 存入redis中的key
     *
     * @return
     */
    protected String getHashRedisKey() {
        return null;
    }

    /**
     * hash  添加
     *
     * @param key    key
     * @param t      对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    public void hashPut(final String key, T t, long expire) {
        hashOperations.put(getHashRedisKey(), key, t);
        if (expire != -1) {
            redisTemplate.expire(getHashRedisKey(), expire, TimeUnit.SECONDS);
        }
    }

    /**
     * hash 删除某个key
     *
     * @param key 传入key的名称
     */
    public void hashRemoveByKey(final String key) {
        hashOperations.delete(getHashRedisKey(), key);
    }

    /**
     * hash  查询
     *
     * @param key 查询的key
     * @return
     */
    public T hashGetByKey(final String key) {
        return hashOperations.get(getHashRedisKey(), key);
    }

    /**
     * hash 获取当前redis库下所有对象
     *
     * @return
     */
    public List<T> hashGetAll() {
        return hashOperations.values(getHashRedisKey());
    }

    /**
     * 查询查询当前redis库下所有key
     *
     * @return
     */
    public Set<String> hashKeys() {
        return hashOperations.keys(getHashRedisKey());
    }

    /**
     * hash 判断key是否存在redis中
     *
     * @param key 传入key的名称
     * @return
     */
    public boolean isHashKeyExists(final String key) {
        return hashOperations.hasKey(getHashRedisKey(), key);
    }

    /**
     * hash 查询当前key下缓存数量
     *
     * @return
     */
    public long hashCount() {
        return hashOperations.size(getHashRedisKey());
    }

    /**
     * hash 清空redis
     */
    public void emptyHash() {
        Set<String> set = hashOperations.keys(getHashRedisKey());
        set.stream().forEach(key -> hashOperations.delete(getHashRedisKey(), key));
    }

}

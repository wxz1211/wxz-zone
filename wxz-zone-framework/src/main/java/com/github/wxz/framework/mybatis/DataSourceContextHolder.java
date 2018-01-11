package com.github.wxz.framework.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 本地线程，数据源上下文
 *
 * @author xianzhi.wang
 * @date 2018/1/11 -11:00
 */
public class DataSourceContextHolder {

    /**
     *  线程本地环境
     */
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();
    private static Logger LOGGER = LoggerFactory.getLogger(DataSourceContextHolder.class);

    public static ThreadLocal<String> getThreadLocal() {
        return THREAD_LOCAL;
    }

    /**
     * 读库
     */
    public static void setRead() {
        THREAD_LOCAL.set(DataSourceType.READ.getType());
    }

    /**
     * 写库
     */
    public static void setWrite() {
        THREAD_LOCAL.set(DataSourceType.WRITE.getType());
    }

    public static String getReadOrWrite() {
        return THREAD_LOCAL.get();
    }

    public static void clear() {
        THREAD_LOCAL.remove();
    }
}

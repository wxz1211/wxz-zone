package com.github.wxz.framework.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @author xianzhi.wang
 * @date 2018/1/10 -17:14
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface WriteDataSource {

}

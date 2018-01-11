package com.github.wxz.framework;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xianzhi.wang
 */
@EnableAutoConfiguration
@EnableTransactionManagement(order = 10) //开启事务，并设置order值，默认是Integer的最大值
@SpringBootApplication(scanBasePackages = {BootApplication.SCAN_PACKAGE})
public class BootApplication extends SpringBootServletInitializer {
    public static final String SCAN_PACKAGE = "com.github.wxz";

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(BootApplication.class);
    }
}

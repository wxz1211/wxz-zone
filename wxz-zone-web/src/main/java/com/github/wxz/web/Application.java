package com.github.wxz.web;

import com.github.wxz.web.framework.BootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author xianzhi.wang
 */
@Configuration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}

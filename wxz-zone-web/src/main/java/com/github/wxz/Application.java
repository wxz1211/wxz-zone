package com.github.wxz;

import com.github.wxz.framework.BootApplication;
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

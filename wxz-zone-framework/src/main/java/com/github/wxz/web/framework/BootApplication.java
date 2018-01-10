package com.github.wxz.web.framework;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author xianzhi.wang
 */
@SpringBootApplication(scanBasePackages = {BootApplication.SCAN_PACKAGE})
public class BootApplication extends SpringBootServletInitializer {
    public static final String SCAN_PACKAGE = "com.github.wxz";

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(BootApplication.class);
    }
}

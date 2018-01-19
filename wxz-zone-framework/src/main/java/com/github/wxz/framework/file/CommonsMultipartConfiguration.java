//package com.github.wxz.framework.file;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//
///**
// * @author xianzhi.wang
// * @date 2018/1/19 -11:19
// */
//@Configuration
//public class CommonsMultipartConfiguration {
//
//    @Bean(name = "commonsMultipartResolver")
//    public CommonsMultipartResolver getCommonsMultipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setDefaultEncoding("UTF-8");
//        multipartResolver.setResolveLazily(true);
//        multipartResolver.setMaxUploadSize(20971520);
//        multipartResolver.setMaxInMemorySize(1048576);
//        return multipartResolver;
//    }
//}

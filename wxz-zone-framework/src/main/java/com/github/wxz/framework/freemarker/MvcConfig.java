//package com.github.wxz.web.framework.freemarker;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
//
///**
// * @author xianzhi.wang
// * @date 2018/1/10 -12:41
// */
//@Configuration
//@EnableWebMvc
//public class MvcConfig extends WebMvcConfigurerAdapter {
//    @Bean
//    public FreeMarkerViewResolver freeMarkerViewResolver() {
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setPrefix("");
//        resolver.setSuffix(".html");
//        resolver.setContentType("text/html; charset=UTF-8");
//        resolver.setRequestContextAttribute("request");
//        return resolver;
//
//    }
//}

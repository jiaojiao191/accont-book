package com.example.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 1. 放行静态资源请求
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");

        // 2. 关键：所有非/api开头的请求，都指向index.html，支持Vue路由
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/index.html");
    }
}
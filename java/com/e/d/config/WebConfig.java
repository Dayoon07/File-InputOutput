package com.e.d.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	// 비디오 파일 경로 매핑
        registry.addResourceHandler("/uploads/**") // HTTP URL 경로
                .addResourceLocations("file:///C:/uploads/"); // 실제 파일 경로
        
        // 이미지 파일 경로 매핑
        registry.addResourceHandler("/uploads/img/**")
                .addResourceLocations("file:///C:/uploads/img/");
    }
}
	
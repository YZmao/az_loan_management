package com.myz.azloanmanage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域处理的配置类
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                //允许访问的路径
                .addMapping("/**")
                //配置请求来源
                .allowedOrigins("http://localhost:8081/")
                //允许访问的方法
                .allowedMethods("GET","POST","DELETE","PUT","POTION")
                //允许存在请求头

                //是否允许携带参数
                .allowCredentials(true)
                //最大效应时间
                .maxAge(3600);

        WebMvcConfigurer.super.addCorsMappings(registry);
    }
}

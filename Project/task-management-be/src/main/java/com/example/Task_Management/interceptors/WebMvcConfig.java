package com.example.Task_Management.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired AuthorizationInterceptor authInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("Interceptor Registered");
        registry.addInterceptor(authInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/**");
                .excludePathPatterns("/users/authenticate","/users/addUser","/users/authenticateTemp","/users/validateToken"); // ,"/addUser","/authenticateTemp","/validateToken"
    }
}

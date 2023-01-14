package com.example.Task_Management;

import com.example.Task_Management.Utilities.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
@ComponentScan({"com.example.Task_Management"})
@EnableMongoRepositories
@EnableScheduling
@EnableWebMvc
public class TaskManagementApplication {
	public static void main(String[] args) throws MessagingException, IOException {
		SpringApplication.run(TaskManagementApplication.class, args);
	}
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
//				registry.addMapping("/**").allowedMethods("POST, GET,OPTIONS, DELETE");
//				registry.addMapping("/**").allowCredentials(true);
//				registry.addMapping("/**").allowedHeaders("Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization");
//
//			}
//		};
//	}
}


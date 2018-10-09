package com.dragon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient
@MapperScan(basePackages = "com.dragon.dao.mapper")
public class DragonBallApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DragonBallApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DragonBallApplication.class, args);
	}
}

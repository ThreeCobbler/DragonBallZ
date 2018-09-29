package com.dragon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
//@EnableEurekaClient
//@EnableDiscoveryClient
@MapperScan(basePackages = "com.dragon.dao.mapper")
public class DragonBallApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DragonBallApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DragonBallApplication.class, args);


//		System.out.println("ヾ(◍°∇°◍)ﾉﾞ    bootdo启动成功      ヾ(◍°∇°◍)ﾉﾞ\n" +
//				" ______                    _   ______            \n" +
//				"|_   _ \\                  / |_|_   _ `.          \n" +
//				"  | |_) |   .--.    .--. `| |-' | | `. \\  .--.   \n" +
//				"  |  __'. / .'`\\ \\/ .'`\\ \\| |   | |  | |/ .'`\\ \\ \n" +
//				" _| |__) || \\__. || \\__. || |, _| |_.' /| \\__. | \n" +
//				"|_______/  '.__.'  '.__.' \\__/|______.'  '.__.'  ");
	}
}

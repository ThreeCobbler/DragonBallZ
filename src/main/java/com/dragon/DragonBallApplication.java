package com.dragon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.dragon.dao.mapper")
public class DragonBallApplication {

	public static void main(String[] args) {
		SpringApplication.run(DragonBallApplication.class, args);
	}
}

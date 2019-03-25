package com.dragon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

//@EnableDiscoveryClient   等价于 @EnableEurekaClient  但是前者还可以用于其他的服务发现工具 如：zooKeeper
@SpringBootApplication
@EnableTransactionManagement
//@EnableEurekaClient
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

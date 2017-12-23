package com.aopLog.demo.aopLogdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.aopLog.demo.aopLogdemo.mapper")
public class AopLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopLogApplication.class, args);
	}

}

package com.turing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.turing.mapper")//扫描接口的包
public class PurchaseProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseProjectApplication.class, args);
	}

}

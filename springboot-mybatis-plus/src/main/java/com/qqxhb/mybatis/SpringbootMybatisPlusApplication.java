package com.qqxhb.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

@SpringBootApplication
@MapperScan("com.qqxhb.mybatis.mapper")
public class SpringbootMybatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisPlusApplication.class, args);
	}

	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}
}

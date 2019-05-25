package com.qqxhb.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

@SpringBootApplication
@MapperScan("com.qqxhb.mybatis.mapper")
public class SpringbootHandleExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHandleExceptionApplication.class, args);
	}

	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}
}

package com.example.JavaShogi;

import org.springframework.boot.SpringApplication;

public class TestJavaShogiApplication {

	public static void main(String[] args) {
		SpringApplication.from(JavaShogiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

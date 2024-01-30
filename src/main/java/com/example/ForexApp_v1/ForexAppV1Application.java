package com.example.ForexApp_v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.ForexApp_v1.model")
@ComponentScan(basePackages = "com.example.ForexApp_v1.service")

public class ForexAppV1Application {

	public static void main(String[] args) {
		SpringApplication.run(ForexAppV1Application.class, args);
	}

}

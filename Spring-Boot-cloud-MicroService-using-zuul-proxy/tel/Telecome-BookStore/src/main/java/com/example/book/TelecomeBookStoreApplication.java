package com.example.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TelecomeBookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelecomeBookStoreApplication.class, args);
	}

}

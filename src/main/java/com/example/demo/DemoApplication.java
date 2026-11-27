
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.example.demo",
		"main.java.com.example.demo"
})
@EntityScan(basePackages = {
		"com.example.demo.model",
		"main.java.com.example.demo.model"
})
@EnableJpaRepositories(basePackages = {
		"com.example.demo.repository",
		"main.java.com.example.demo.repository"
})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

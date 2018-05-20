package com.n26.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is main class of this project
 * @author dhiren
 * @since 19-05-2018
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.n26.transaction")
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

package com.xeness.js;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootAngularJsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngularJsApplication.class, args);
	}

}

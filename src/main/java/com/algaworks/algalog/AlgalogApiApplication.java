package com.algaworks.algalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AlgalogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgalogApiApplication.class, args);
	}

}

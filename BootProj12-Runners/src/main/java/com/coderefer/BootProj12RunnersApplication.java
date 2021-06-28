package com.coderefer;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootProj12RunnersApplication {
	
	@Bean
	public CommandLineRunner createCLRunner() {
		return a -> System.out.println("Scheduling Runner");
	}
	
	@Bean
	public ApplicationRunner createAplnRunner() {
		return a -> System.out.println("Timer Runner");
	}

	public static void main(String[] args) {
		SpringApplication.run(BootProj12RunnersApplication.class, args);
		
	}
}


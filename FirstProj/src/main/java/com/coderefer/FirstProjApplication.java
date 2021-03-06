package com.coderefer;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.coderefer.beans.WishMessageGenerator;

@SpringBootApplication
public class FirstProjApplication {
	
	@Bean(name="ldt")
	@Scope("prototype")
	public LocalDateTime createLocalDateTime() {
		System.out.println("FirstProjApplication.createLocalDateTime()");
		return LocalDateTime.now();
	}	
	
	@Bean(name="ldt1")
	@Scope("prototype")
	public LocalDateTime createLocalDateTime1() {
		System.out.println("FirstProjApplication.createLocalDateTime()");
		return LocalDateTime.now();
	}


	public static void main(String[] args) {
//		get IOC Container
		ApplicationContext ctx = SpringApplication.run(FirstProjApplication.class, args);
//		get target spring bean class from IOC Container
		WishMessageGenerator generator = ctx.getBean("wmg", WishMessageGenerator.class);
//		invoke methods
		String result = generator.generateWishMessage("Vamsi");
		System.out.println(result);
//		close container
		((ConfigurableApplicationContext)ctx).close();
	}

}

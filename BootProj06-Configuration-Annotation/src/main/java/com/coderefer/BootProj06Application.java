package com.coderefer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.coderefer.beans.CompanyDetails;
import com.coderefer.beans.CompanyDetails1;

@SpringBootApplication
public class BootProj06Application {

	public static void main(String[] args) {
//		get IOC Container
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj06Application.class, args);
		CompanyDetails c = ctx.getBean("company", CompanyDetails.class);
		System.out.println("data::" + c);
		CompanyDetails1 c1 = ctx.getBean("company1", CompanyDetails1.class);
		System.out.println("data::" + c1);
		ctx.close();
	}

}

package com.coderefer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.coderefer.model.Employee;

@SpringBootApplication
public class BootProj08InjectingValuesToAllSpringBeanPropertiesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj08InjectingValuesToAllSpringBeanPropertiesApplication.class, args);
		
		Employee emp = ctx.getBean("emp", Employee.class);
		System.out.println(emp);
		ctx.close();
	}

}

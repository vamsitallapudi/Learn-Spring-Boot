package com.coderefer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.coderefer.beans.Student;

@SpringBootApplication
@ImportResource("com/coderefer/cfgs/applicationContext.xml")
public class BootProj2DependencyInjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj2DependencyInjectionApplication.class, args);
		Student std = ctx.getBean("stud", Student.class);
		std.preparation("AWS Certification");
//		close container
		ctx.close();
	}

}

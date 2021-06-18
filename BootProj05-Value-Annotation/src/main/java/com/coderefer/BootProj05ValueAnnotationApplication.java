package com.coderefer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.coderefer.beans.BillGenerator;

@SpringBootApplication
public class BootProj05ValueAnnotationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj05ValueAnnotationApplication.class, args);
		BillGenerator generator = ctx.getBean("bill", BillGenerator.class);
		System.out.println("data::" + generator);
		ctx.close();
	}

}

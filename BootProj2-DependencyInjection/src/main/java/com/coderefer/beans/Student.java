package com.coderefer.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("stud")
public class Student {
	@Autowired 
	@Qualifier("Java")
	private ICourseMaterial material;
	
	public void preparation(String examName) {
		System.out.println("preparation started for " + examName);
		String courseContent = material.courseContent();
		double price = material.price();
		System.out.println("Preparation is going on using " + courseContent + "with price: " + price);
		System.out.println("Preparation is completed for " + examName);
	}
}

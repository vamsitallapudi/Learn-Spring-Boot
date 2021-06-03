package com.coderefer.beans;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("stud")
public final class Student {
	@Autowired
//	@Qualifier("Java")
	@Resource(name="courseId")
	private ICourseMaterial material; //HAS-A property
	
	public void preparation(String examName) {
		System.out.println("preparation started for " + examName);
		String courseContent = material.courseContent();
		double price = material.price();
		System.out.println("Preparation is going on using " + courseContent + "with price: " + price);
		System.out.println("Preparation is completed for " + examName);
	}
}

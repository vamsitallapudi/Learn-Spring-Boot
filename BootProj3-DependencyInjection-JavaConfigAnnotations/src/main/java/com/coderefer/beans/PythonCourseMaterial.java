package com.coderefer.beans;

import javax.inject.Named;

import org.springframework.context.annotation.Primary;

@Primary
@Named("Python")
public final class PythonCourseMaterial implements ICourseMaterial{
	
	public PythonCourseMaterial() {
		System.out.println("PythonCourseMaterial:: 0-param constructor");
	}

	@Override
	public String courseContent() {
		return "1.OOPS, 2.Exception Handling, 3. Multiple Inheritance and etc.";
	}

	@Override
	public double price() {
		return 500;
	}

}


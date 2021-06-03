package com.coderefer.beans;

import javax.inject.Named;

@Named("Java")
public final class JavaCourseMaterial implements ICourseMaterial{
	
	public JavaCourseMaterial() {
		System.out.println("JavaCourseMaterial:: 0-param constructor");
	}

	@Override
	public String courseContent() {
		return "1.OOPS, 2.Exception Handling, 3. Collections and etc.";
	}

	@Override
	public double price() {
		return 400;
	}

}

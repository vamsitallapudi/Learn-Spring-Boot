package com.coderefer.beans;

import org.springframework.stereotype.Component;

@Component("UI")
public final class UICourseMaterial implements ICourseMaterial{
	
	public UICourseMaterial() {
		System.out.println("UICourseMaterial:: 0-param constructor");
	}

	@Override
	public String courseContent() {
		return "1.UI Content, 2.UI Design, 3. Bootstrap and etc.";
	}

	@Override
	public double price() {
		return 300;
	}

}


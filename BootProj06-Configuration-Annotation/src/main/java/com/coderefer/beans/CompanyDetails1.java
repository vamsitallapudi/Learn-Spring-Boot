package com.coderefer.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("company1")
public class CompanyDetails1 {
	@Value("${com.coderefer.name}")
	private String name;
	@Value("${com.coderefer.type}")
	private String type;
	@Value("${com.coderefer.location}")
	private String addrs;
	
	@Override
	public String toString() {
		return "CompanyDetails [name=" + name + ", type=" + type + ", location=" + addrs + "]";
	}
	
}

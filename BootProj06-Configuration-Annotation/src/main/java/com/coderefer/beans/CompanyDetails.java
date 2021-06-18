package com.coderefer.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("company")
@ConfigurationProperties(prefix="com.coderefer")
@Data
public class CompanyDetails {
	private String name;
	private String type;
	private String location;
	
	@Override
	public String toString() {
		return "CompanyDetails [name=" + name + ", type=" + type + ", location=" + location + "]";
	}
	
	
	
}

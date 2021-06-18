package com.coderefer.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("info")
@PropertySource("classpath:commons/inputs.properties")
public class ItemsInfo {
	@Value("${shirt.price}")
	public float shirtPrice;
	@Value("${pant.price}")
	public float pantPrice;
	@Value("${belt.price}")
	public float beltPrice;
	
	
	@Override
	public String toString() {
		return "ItemsInfo [shirtPrice=" + shirtPrice + ", pantPrice=" + pantPrice + ", beltPrice=" + beltPrice + "]";
	}
	

}

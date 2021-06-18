package com.coderefer.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bill")
public class BillGenerator {
	@Value("#{info.shirtPrice + info.pantPrice + info.beltPrice}")
	private float total;
	@Value("Central")
	private String storeName;
	
	@Autowired
	private ItemsInfo items;

	@Override
	public String toString() {
		return "BillGenerator [total=" + total + ", storeName=" + storeName + ", items=" + items + "]";
	}
}

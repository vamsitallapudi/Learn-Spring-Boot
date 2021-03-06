package com.coderefer.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	@Autowired // Field Injection
	@Qualifier("ldt1")
	private LocalDateTime date;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator::0-param constructor");
	}
	
	public String generateWishMessage(String user) {
//		get current hour of the day
		int hour = date.getHour();
//		generate wish message
		if(hour < 12)
			return "Good Morning " + user;
		else if (hour > 12 && hour < 19)
			return "Good Afternoon "+ user;
		else
			return "Good Night " + user;
	}
}

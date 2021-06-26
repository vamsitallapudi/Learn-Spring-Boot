package com.coderefer.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AlertServiceRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("AlertServiceRunner.run(..): The command line args are: ");
		System.out.println(Arrays.toString(args));
	}
	
}

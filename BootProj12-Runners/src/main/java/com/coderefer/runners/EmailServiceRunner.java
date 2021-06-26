package com.coderefer.runners;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceRunner implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("EmailServiceRunner.run()");
		System.out.println("Non-option args: " + args.getNonOptionArgs()); //only value will be there, no key
		System.out.println("option args: " + args.getOptionNames()); //contains -key=val, this method gives only keys
		System.out.println("Source args: " + Arrays.toString(args.getSourceArgs()));
	}


}

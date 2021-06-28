package com.coderefer.runners;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(-2)
public class EmailServiceRunner implements ApplicationRunner, Ordered{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("EmailServiceRunner.run()");
		System.out.println("Non-option args: " + args.getNonOptionArgs()); //only value will be there, no key
		System.out.println("option args: " + args.getOptionNames()); //contains -key=val, this method gives only keys
		System.out.println("Source args: " + Arrays.toString(args.getSourceArgs()));
	}

	@Override
	public int getOrder() {
		return 15;
	}


}

package com.coderefer;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.coderefer.controller.MainController;
import com.coderefer.vo.EmployeeVO;

@SpringBootApplication
public class BootProj04RealtimeDiAutoConfigurationApplication {

	public static void main(String[] args) {
//		read inputs from end user
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Desgs count::");
		int count = sc.nextInt();
		String desgs[] = null;
		if (count >=1) {
			desgs = new String[count];
		} else {
			System.out.println("Invalid desg count");
			return;
		}
		for (int i = 0; i< count; ++i) {
			System.out.println("Enter Desg: " +  (i+1));
			String desg = sc.next();
			desgs[i] = desg;
		}
//		get IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj04RealtimeDiAutoConfigurationApplication.class, args);
		
		MainController controller = ctx.getBean("controller", MainController.class);
		try {
			List<EmployeeVO> listVO = controller.showEmpsByDesg(desgs);
			listVO.forEach(vo-> {
				System.out.println(vo);
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some Internal Problem: " + e.getMessage());
		}
		((ConfigurableApplicationContext) ctx).close();
	}

}

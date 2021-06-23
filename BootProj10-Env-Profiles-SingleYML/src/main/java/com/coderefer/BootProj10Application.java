package com.coderefer;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import com.coderefer.controller.MainController;
import com.coderefer.vo.EmployeeVO;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@SpringBootApplication
public class BootProj10Application {
	
	@Autowired
	private Environment env;
	
	@Bean(name="cds")
	@Profile("uat")
	public ComboPooledDataSource createCoPoDs() throws Exception{
		System.out.println("BootProj10Application.createCoPoDs()");
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		ds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		ds.setUser(env.getRequiredProperty("spring.datasource.username"));
		ds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return ds;
	}

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
		SpringApplication appln = new SpringApplication(BootProj10Application.class);
		appln.setAdditionalProfiles("uat");
		ApplicationContext ctx = appln.run(args);
		
//		Trying to change env via code but not working.
		ConfigurableEnvironment env = (ConfigurableEnvironment)ctx.getEnvironment();
		
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

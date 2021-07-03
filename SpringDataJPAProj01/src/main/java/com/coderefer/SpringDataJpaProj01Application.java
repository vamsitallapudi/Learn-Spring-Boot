package com.coderefer;

import com.coderefer.entity.CoronaVaccine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.coderefer.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class SpringDataJpaProj01Application {

	public static void main(String[] args) {
		//get Access to IOC container
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj01Application.class, args);
		//get Service class obj
		ICoronaVaccineMgmtService  service=ctx.getBean("vaccineMgmtService", ICoronaVaccineMgmtService.class);
		 //invoke methods
		try {
//		   	create Entity class obj
			CoronaVaccine vaccine=
					new CoronaVaccine("covaxin",
							"Bharat Biotech", "India",
							749.0, 2);
			System.out.println(service.registerVaccine(vaccine));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}

package com.bee.pdf.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bee.pdf.demo.entity.Bees;
import com.bee.pdf.demo.service.BeeService;

@SpringBootApplication
public class DemoApplication 
implements CommandLineRunner
{

	@Autowired
	private BeeService beeService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	public void run(String... a) {
		for (int i = 1; i <=1; i++) {
			Bees bee = new Bees();
			bee.setBeeName("Mark" + i);
			bee.setEmail("mark" + i + "@test.com");
			bee.setMobileNo("9999999999");
			bee.setSalary(6000L);
			bee.setDoj("2023-05-01");
			beeService.addBee(bee);
		}
	}
	 
}

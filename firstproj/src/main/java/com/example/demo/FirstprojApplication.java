package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstprojApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(FirstprojApplication.class, args);
		
		Car obj=context.getBean(Car.class);
		obj.setName("Brezza");
		System.out.println(obj.getName());
		obj.collab();
		
	}

}

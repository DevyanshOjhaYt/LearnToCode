package com.example.demo;

import java.util.List;

import org.apache.logging.log4j.core.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.model.Student;

@Aspect
@Component
public class LoggingAspect {

	public static final org.slf4j.Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.example.demo.StudentController.getStudents())")
	public void logBefore()
	{
	//System.out.println("Logging Level-------------");
		LOGGER.info("getStudent from Aspect");
	}
	
	@After("execution(public * com.example.demo.StudentController.getStudents())")
	public void logAfter()
	{
	//System.out.println("Logging Level-------------");
		LOGGER.info("getStudent from Aspect");
	}
	
	
	@AfterReturning("execution(public * com.example.demo.StudentController.getStudents())")
	public void logAfterReturning()
	{
	//System.out.println("Logging Level-------------");
		LOGGER.info("getStudent from Aspect after returning");
	}
	
	
	@AfterThrowing("execution(public * com.example.demo.StudentController.getStudents())")
	public void logAfterThrowing()
	{
	//System.out.println("Logging Level-------------");
		LOGGER.info("getStudent from Aspect after throwing");
	}
	
	
}

package com.telusko.SpringDemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//BeanFactory context=new XmlBeanFactory(new FileSystemResource("spring.xml"));
    	ApplicationContext context=new ClassPathXmlApplicationContext("app-context.xml");
    	Alien obj=(Alien) context.getBean("alien");
        obj.call();
    }
}

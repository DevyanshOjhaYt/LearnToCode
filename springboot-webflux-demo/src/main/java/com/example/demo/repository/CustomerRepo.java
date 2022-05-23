package com.example.demo.repository;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerRepo {

	private static void sleepExecution(int i)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Customer> getCustomers()
	{
		return IntStream.rangeClosed(1, 10)
				 .peek(CustomerRepo::sleepExecution)
		         .peek(i->System.out.println("Processing count : "+i))
		         .mapToObj(i->new Customer(i,"customer"+i))
		         .collect(Collectors.toList());
	}
	public Flux<Customer> getCustomersStream()
	{
		return Flux.range(1, 10)
				   .delayElements(Duration.ofSeconds(1))
				   .doOnNext(i->System.out.println("Pocessing count In Stream Flow : "+i))
				   .map(i->new Customer(i,"customer "+i));
	}
	
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepo;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	public List<Customer> loadAllCustomers() {
		long start = System.currentTimeMillis();
		List<Customer> customers = customerRepo.getCustomers();
		long end = System.currentTimeMillis();
		System.out.println("Total time of execution " + (end - start));
		return customers;
	}
	public Flux<Customer> loadAllCustomersStream() {
		long start = System.currentTimeMillis();
		Flux<Customer> customers = customerRepo.getCustomersStream();
		long end = System.currentTimeMillis();
		System.out.println("Total time of execution " + (end - start));
		return customers;
	}
}

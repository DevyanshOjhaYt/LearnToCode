package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public List<Customer> getCustomer() {
		return customerService.loadAllCustomers();
	}
	
	@GetMapping(value="/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> getCustomerStream() {
		return customerService.loadAllCustomersStream();
	}

}

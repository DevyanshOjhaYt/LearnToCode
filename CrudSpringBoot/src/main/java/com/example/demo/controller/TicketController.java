package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TicketDao;
import com.example.demo.model.Ticket;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketDao ticketDao;
	
	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Ticket> tickets)
	{
		return "Ticket Booked:"+tickets.size();
	}
	@GetMapping("/getTickets")
	public List<Ticket> getTick()
	{
		return (List<Ticket>)ticketDao.findAll();
	}
	
}

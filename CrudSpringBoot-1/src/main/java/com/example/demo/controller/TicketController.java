package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.custom.exception.BusinessException;
import com.example.demo.custom.exception.ControllerException;
import com.example.demo.model.Ticket;
import com.example.demo.repos.TicketRepo;
import com.example.demo.service.TicketServiceInterface;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketServiceInterface ticketServiceInterface;

	@PostMapping("/bookTickets")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Ticket tickets) {
		return new ResponseEntity<Ticket>(ticketServiceInterface.addTicket(tickets), HttpStatus.CREATED);
	}

	@GetMapping("/getTickets")
	public ResponseEntity<List<Ticket>> getTick() {
		return new ResponseEntity<List<Ticket>>(ticketServiceInterface.findAllTickets(), HttpStatus.OK);
	}

	@GetMapping("/getTicketsById/{id}")
	public ResponseEntity<?> getTicketById(@PathVariable("id") int idd) {
		try {
			return new ResponseEntity<Ticket>(ticketServiceInterface.findTicketById(idd), HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("608", "Something went wrong");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/deleteTicketsById/{id}")
	public String delTicketById(@PathVariable("id") int idd) {
		return ticketServiceInterface.deleteTicketById(idd);
	}

	@PutMapping("/putTicket")
	public ResponseEntity<Ticket> UpdateTicket(@RequestBody Ticket ticket) {
		return new ResponseEntity<Ticket>(ticketServiceInterface.addTicket(ticket), HttpStatus.OK);
	}

}

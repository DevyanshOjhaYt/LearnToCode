package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Ticket;

public interface TicketServiceInterface {

	Ticket addTicket(Ticket tickets);

	List<Ticket> findAllTickets();

	Ticket findTicketById(int id);

	String deleteTicketById(int idd);

}

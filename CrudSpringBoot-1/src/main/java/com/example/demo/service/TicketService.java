package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.custom.exception.BusinessException;
import com.example.demo.model.Ticket;
import com.example.demo.repos.TicketRepo;

@Service
public class TicketService implements TicketServiceInterface {

	@Autowired
	private TicketRepo ticketRepo;

	@Override
	public Ticket addTicket(Ticket tickets) {
		return ticketRepo.save(tickets);

	}

	@Override
	public List<Ticket> findAllTickets() {

		return (List<Ticket>) ticketRepo.findAll();
	}

	@Override
	public Ticket findTicketById(int id) {
//		
//		if(id==0)
//			return new BusinessException("603", "empty id");
//		
		//for validation try should be outside
		try {
			return ticketRepo.findById(id).get();
		} catch (IllegalArgumentException e) {
			throw new BusinessException("606", "given employee id is null, please send some valid id" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("607", "given employee id does not exists in DB" + e.getMessage());
		}

	}

	@Override
	public String deleteTicketById(int idd) {
		ticketRepo.deleteById(idd);
		return "Deletion Is Done";
	}
}

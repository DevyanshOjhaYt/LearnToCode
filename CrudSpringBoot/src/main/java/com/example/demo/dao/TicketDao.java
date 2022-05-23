package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Ticket;


public interface TicketDao extends CrudRepository<Ticket, Integer> {
//here Ticket is the model class and Integer is the datatype of primary key
}

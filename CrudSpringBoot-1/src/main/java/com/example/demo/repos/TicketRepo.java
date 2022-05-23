package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {
//here Ticket is the model class and Integer is the datatype of primary key
}

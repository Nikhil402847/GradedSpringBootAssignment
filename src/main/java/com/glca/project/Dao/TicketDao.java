package com.glca.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glca.project.Model.Ticket;

@Repository
public interface TicketDao extends JpaRepository<Ticket, Long> {
	

}

package com.glca.project.Service;

import java.util.List;

import com.glca.project.Model.Ticket;

public interface ITicketService {

	List<Ticket> findAllTicktet();
	public Ticket addTicket(Ticket t);
	public Boolean deleteTicket(long id);
	public Ticket UpdateTicket(Ticket ticket);
	public Ticket findTicketbyId(long id);
	public List<Ticket> findTicketbytitle(String title);
}

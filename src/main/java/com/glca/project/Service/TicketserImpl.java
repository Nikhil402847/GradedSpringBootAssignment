package com.glca.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glca.project.Dao.TicketDao;
import com.glca.project.Model.Ticket;

@Service
public class TicketserImpl implements ITicketService {

	@Autowired
	private TicketDao ticketdoa;
	@Override
	public List<Ticket> findAllTicktet() {
		// TODO Auto-generated method stub
		return ticketdoa.findAll();
	}

	@Override
	public Ticket addTicket(Ticket t) {
		// TODO Auto-generated method stub
		ticketdoa.save(t);
		return t;
	}

	@Override
	public Boolean deleteTicket(long id) {
		// TODO Auto-generated method stub
		ticketdoa.deleteById(id);
		return true;
	}

	@Override
	public Ticket UpdateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		Ticket t = findTicketbyId(ticket.getId());
		t.setContent(ticket.getContent());
		t.setTitle(ticket.getTitle());
		t.setShortDescription(ticket.getShortDescription());
		addTicket(t);
		return ticket;
	}

	@Override
	public Ticket findTicketbyId(long id) {
		// TODO Auto-generated method stub
		return ticketdoa.findById(id).get();
	}


	@Override
	public List<Ticket> findTicketbytitle(String title) {
		// TODO Auto-generated method stub
		return ticketdoa.findAll();
	}

}

package com.glca.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glca.project.Model.Ticket;
import com.glca.project.Service.ITicketService;

@Controller
public class TicketController {

	@Autowired
	public ITicketService ticketservice;
	
	@GetMapping("/tickets")
	public String tickets(Model model) {
		List<Ticket> tickets=ticketservice.findAllTicktet();
		model.addAttribute("tickets", tickets);
		return "tickets";
	}
	@GetMapping("newTicket")
	public String newTicketForm(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "createticket";
	}
	@PostMapping("/tickets")
	public String saveTicketForm(@ModelAttribute("ticket") Ticket t) {
		ticketservice.addTicket(t);
		return "redirect:/tickets";
	}
	@GetMapping("/delete")
	public String DeleteTicket(@RequestParam("ticketId") long ticketId) {
		System.out.println(ticketId);
		ticketservice.deleteTicket(ticketId);
		return "redirect:/tickets";
	}
	@GetMapping("/view")
	public String ViewTicket(@RequestParam("ticketId") long ticketId,Model model) {
		Ticket ticket = ticketservice.findTicketbyId(ticketId);
		model.addAttribute("ticket", ticket);
		return "view_page";	
	}
	@GetMapping("/edit")
	public String editTicketForm(@RequestParam("ticketId") Long ticketId, Model model) {

		Ticket ticket = ticketservice.findTicketbyId(ticketId);
		model.addAttribute("ticket", ticket);
		return "edit_page";
	}
	public String UpdateTicket(@ModelAttribute("ticket") Ticket t) {
		ticketservice.UpdateTicket(t);
		return "redirect:/tickets";
	}
	
}

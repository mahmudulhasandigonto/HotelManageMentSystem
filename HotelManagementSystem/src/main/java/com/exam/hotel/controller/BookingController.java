package com.exam.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.hotel.entity.Booking;
import com.exam.hotel.entity.Room;
import com.exam.hotel.repository.BookingRepository;
import com.exam.hotel.repository.RoomRepository;

@Controller
public class BookingController {
	@Autowired
	BookingRepository brep;
	@Autowired
	RoomRepository rrep;
	
	
	  String userEmailId;
	  
	  @ModelAttribute public void posUseremail(Model model) {
	  model.addAttribute("user",userEmailId); 
	  }
	 

	@RequestMapping("/showBooking/{userEmailId}")
	public String showBooking(@PathVariable("userEmailId") String useremailId, Model model) {
		System.out.println(useremailId);
		 userEmailId = useremailId;
		  model.addAttribute("user",userEmailId);
		
		List<Booking> guest = brep.findAll();
		model.addAttribute("booking", guest);
		return "user/bookingTemp";
	}

	@RequestMapping("/add")
	public String bookingAdd(Model model) {
		List<Room> room = rrep.findAll();
		model.addAttribute("room",room);
		return "user/bookingAdd";
	}

	@PostMapping("/bookingProcess")
	public String bookingAddProcess(@ModelAttribute Booking booking) {
		brep.save(booking);
		return "redirect:/showBooking/"+userEmailId;
	}

	@RequestMapping("/bookingUpdateForm/{bId}")
	public String bookingUpdateForm(@PathVariable("bId") long bid, Model model) {
		model.addAttribute("room", rrep.findAll());
		model.addAttribute("booking", brep.findById(bid).get());
		return "user/bookingUpdate";
	}

	@PostMapping("/bookingUpdate")
	public String bookingUpdate(@ModelAttribute Booking booking) {
		brep.save(booking);
		return "redirect:/showBooking/"+userEmailId;
	}

	@GetMapping("/deleteBooking/{bId}")
	public String bookingDelete(@PathVariable("bId") long bid) {
		Booking booking = brep.findById(bid).get();
		brep.delete(booking);
		return "redirect:/showBooking/"+userEmailId;
	}

}

package com.exam.hotel.controller;

import java.sql.Date;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.hotel.entity.PosUser;
import com.exam.hotel.repository.BookingRepository;
import com.exam.hotel.repository.CheckInRepository;
import com.exam.hotel.repository.CheckOutTransactionRepository;
import com.exam.hotel.repository.PosUserRepository;
import com.exam.hotel.repository.RoomsRepository;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	PosUserRepository posurep;
	@Autowired
	BookingRepository bookingrep;
	@Autowired
	CheckInRepository checkinrep;
	@Autowired
	CheckOutTransactionRepository checkouttrarep;
	@Autowired
	RoomsRepository roomsrep;
	
	String userEmailId;
	@ModelAttribute
	public void posUseremail(Model model) {
		model.addAttribute("user",userEmailId);
	}

	@PostMapping("/dologin")
	public String loginprocess(@RequestParam("userEmail") String useremail,
			@RequestParam("userPassword") String userPassword, Model model) {
		PosUser user = posurep.findByUserEmailAndUserPassword(useremail, userPassword);
		if (user == null) {
			model.addAttribute("error", "User Email or Password is Invalid!!");
			return "login";
		} else {
			userEmailId=useremail;
			model.addAttribute("user",userEmailId);
			
			return "/user/user-dashboard";

		}

	}

	@RequestMapping("/dashboard")
	public String userDashboard(Model model) {

		// ----- Current Date in sql format---------
		long millis = System.currentTimeMillis();
		Date todaysDate = new Date(millis);

		// ----- Todays Arrival-------
		model.addAttribute("todaysArrival", bookingrep.findByCheckind(todaysDate).size());

		// ----- Total Booking--------
		model.addAttribute("totalBooking", bookingrep.findAll().size());

		// ---- Total Occupied-------
		int totalOccupaied = checkinrep.findAll().size();
		model.addAttribute("totalOccupaid", totalOccupaied);

		// ---- Todays Total Check-in----.
		model.addAttribute("totalCheckin", checkinrep.findByGuestCheckin(todaysDate).size());

		// ---- Todays Total Departure -----
		model.addAttribute("totalDeparture", checkinrep.findByGuestCheckout(todaysDate).size());

		// ---- Total Guest --------
		model.addAttribute("totalGuest", checkinrep.findTotalGuest());

		// ---- Total Check-out----
		model.addAttribute("totalCheckout", checkouttrarep.findByTransactionDate(todaysDate).size());

		// ---- Total Vacant ------
		model.addAttribute("totalVacant", roomsrep.findByRoomStatus("Vacant").size());

		// ---- Total Occupancy-------
		double totalRoom = roomsrep.count();
		double occupaied = totalOccupaied;
		double occupancy = occupaied * 100 / totalRoom;
		DecimalFormat formatter = new DecimalFormat("#0.00");
		model.addAttribute("occupancy", formatter.format(occupancy));

		return "/user/user-dashboard";

	}

}

package com.exam.hotel.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.hotel.entity.CheckIn;
import com.exam.hotel.entity.CheckInRecord;
import com.exam.hotel.entity.OtherServicesRecord;
import com.exam.hotel.entity.Rooms;
import com.exam.hotel.repository.CheckInRecordRepository;
import com.exam.hotel.repository.CheckInRepository;
import com.exam.hotel.repository.OtherServicesRepository;
import com.exam.hotel.repository.RoomRepository;
import com.exam.hotel.repository.RoomsRepository;

@Controller
public class CheckInController {
	@Autowired
	RoomRepository rrep;
	@Autowired
	RoomsRepository roomsrep;
	@Autowired
	CheckInRepository checkinrep;
	@Autowired
	CheckInRecordRepository checkinrecordrep;
	@Autowired
	OtherServicesRepository otrep;

	List<String> paymentStatus = List.of("Success", "Unsuccess");

	String userEmailId;

	@ModelAttribute
	public void posUseremail(Model model) {
		model.addAttribute("user", userEmailId);
	}

	@RequestMapping("/check-in/{useremailId}")
	public String checkIn(@PathVariable("useremailId") String useremailId, Model model) {

		userEmailId = useremailId;
		model.addAttribute("user", userEmailId);

		model.addAttribute("room", rrep.findAll());
		model.addAttribute("paymentStatus", paymentStatus);
		model.addAttribute("rooms", roomsrep.findAll());

		long millis = System.currentTimeMillis();
		Date todaysDate = new Date(millis);
		model.addAttribute("currentDate", todaysDate);
		return "user/check-in";

	}

	@PostMapping("/checkInProcess")
	public String checkInProcess(@ModelAttribute CheckIn checkin, @ModelAttribute CheckInRecord checkinrecord) {
		Rooms rooms = roomsrep.findByRoomNo(checkin.getGuestRoomNo());
		String roomStatus = rooms.getRoomStatus();

		if (roomStatus.equals("Vacant")) {
			checkinrep.save(checkin);
			checkinrecordrep.save(checkinrecord);

			rooms.setRoomStatus("Occupaid");
			roomsrep.save(rooms);
			return "redirect:/guestDetails";
		} else {
			return "redirect:/check-in/"+userEmailId;
		}

	}

	@RequestMapping("/guestDetails")
	public String guestDetails(Model model) {
		model.addAttribute("checkin", checkinrep.findAll());
		return "user/check-in-guestDetails";
	}

	@RequestMapping("/guestProfileUpdateForm/{regNo}")
	public String guestProfileUpdateForm(@PathVariable("regNo") long regNo, Model model) {
		model.addAttribute("room", rrep.findAll());
		model.addAttribute("paymentStatus", paymentStatus);
		model.addAttribute("checkin", checkinrep.findById(regNo).get());
		return "user/guestProfileUpdate";
	}

	@PostMapping("/guestProfileUpdateProcess")
	public String guestProfileProcess(@ModelAttribute CheckIn checkin, @ModelAttribute CheckInRecord checkinrecord) {
		checkinrep.save(checkin);
		checkinrecordrep.save(checkinrecord);
		System.out.println("working");
		return "redirect:/guestDetails";
	}

	@RequestMapping("/guestProfile/{regNo}")
	public String guestProfile(@PathVariable("regNo") long regNo, Model model) {
		CheckIn checkIn = checkinrep.findById(regNo).get();
		model.addAttribute("checkin", checkIn);
		List<OtherServicesRecord> others = otrep.findByGuestRegNo(regNo);
		model.addAttribute("others", others);

		// --------- Due calculation-----------
		double totalRent = checkIn.getGuestTotalRent();
		double othersBill = checkIn.getGuestOtherServices();
		double guestDeposit = checkIn.getGuestDeposit();
		double subTotal = totalRent + othersBill;
		double due = subTotal - guestDeposit;
		model.addAttribute("subTotal", subTotal);
		model.addAttribute("due", due);

		return "user/check-inGuestProfile";
	}

}

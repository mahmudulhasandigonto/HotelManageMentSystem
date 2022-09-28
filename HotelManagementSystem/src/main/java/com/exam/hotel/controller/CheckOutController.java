package com.exam.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.hotel.entity.CheckIn;
import com.exam.hotel.entity.CheckInRecord;
import com.exam.hotel.entity.CheckOutTransaction;
import com.exam.hotel.entity.OtherServicesRecord;
import com.exam.hotel.entity.Rooms;
import com.exam.hotel.repository.CheckInRecordRepository;
import com.exam.hotel.repository.CheckInRepository;
import com.exam.hotel.repository.CheckOutTransactionRepository;
import com.exam.hotel.repository.OtherServicesRepository;
import com.exam.hotel.repository.RoomsRepository;

@Controller
public class CheckOutController {
	@Autowired
	CheckInRepository checkinrep;
	@Autowired
	CheckInRecordRepository checkinrrep;
	@Autowired
	CheckOutTransactionRepository checkoutrep;
	@Autowired
	OtherServicesRepository otrep;
	@Autowired
	RoomsRepository roomsrep;
	
	String userEmailId;
	@ModelAttribute
	public void posUseremail(Model model) {
		model.addAttribute("user",userEmailId);
	}

	@RequestMapping("/check-out-Home/{useremailId}")
	public String checkOutHome(@PathVariable("useremailId") String useremailId, Model model) {
		userEmailId=useremailId;
		model.addAttribute("user",userEmailId);
		
		return "user/check-out-Home";
	}

	@RequestMapping("/fornt-office-pos")
	public String forntOfficePos(Model model) {
		CheckIn checkin = new CheckIn();
		model.addAttribute("checkin", checkin);

		return "user/fornt-office-pos";
	}

	@PostMapping("/fornt-office-data")
	public String fornOfficePosData(@RequestParam("roomNo") int rno, Model model) {
		List<CheckIn> list = checkinrep.findByGuestRoomNo(rno);
		if (list.size() != 0) {
			CheckIn checkin = checkinrep.findByGuestRoomNo(rno).get(0);
			model.addAttribute("checkin", checkin);
			double totalAmount = checkin.getGuestTotalRent() + checkin.getGuestOtherServices();
			double grandAmount = totalAmount- checkin.getGuestDeposit();
			model.addAttribute("grandTotal",grandAmount);
			model.addAttribute("subTotal", totalAmount);
			return "user/fornt-office-pos";
		} else {
			return "redirect:/fornt-office-pos";
		}

	}

	@PostMapping("/saveCheckoutTransaction")
	public String saveTransaction(@ModelAttribute CheckOutTransaction checkoutT,
			@RequestParam("guestRegNo") long regno) {
		System.out.println("transaction");
		checkoutrep.save(checkoutT);

		CheckIn checkin = checkinrep.findById(regno).get();
		checkin.setGuestPaymentStatus("Success");
		checkinrep.save(checkin);

		CheckInRecord checkInRecord = checkinrrep.findById(regno).get();
		checkInRecord.setGuestPaymentStatus("Success");
		checkinrrep.save(checkInRecord);
		return "redirect:/fornt-office-pos";
	}

	@PostMapping("/check-out-guestProfile")
	public String checkoutGuestProfile(@RequestParam("roomNo") int rno, Model model) {
		List<CheckIn> list = checkinrep.findByGuestRoomNo(rno);
		if (list.size() != 0) {
			CheckIn checkIn = checkinrep.findByGuestRoomNo(rno).get(0);
			model.addAttribute("checkin", checkIn);

			List<OtherServicesRecord> others = otrep.findByGuestRegNo(checkIn.getGuestRegNo());
			model.addAttribute("others", others);

			// --------- Due calculation-----------
			double totalRent = checkIn.getGuestTotalRent();
			double othersBill = checkIn.getGuestOtherServices();
			double guestDeposit = checkIn.getGuestDeposit();
			double subTotal = totalRent + othersBill;
			double due = subTotal - guestDeposit;
			model.addAttribute("subTotal", subTotal);
			model.addAttribute("due", due);

			return "user/check-out-GuestProfile";
		} else {
			return "user/check-out-Home";
		}

	}

	@RequestMapping("check-out-guest/{regNo}/{roomNo}")
	public String checkOutGuest(@PathVariable("regNo") long regNo, @PathVariable("roomNo") int roomNo, Model model) {
		checkinrep.deleteById(regNo);
		Rooms rooms = roomsrep.findByRoomNo(roomNo);
		rooms.setRoomStatus("Checked-out");
		roomsrep.save(rooms);
		model.addAttribute("msg", "Check-out Successful!!");
		return "user/check-out-Home";
	}

}

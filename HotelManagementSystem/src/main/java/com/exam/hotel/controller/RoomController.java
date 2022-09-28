package com.exam.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.hotel.entity.Room;
import com.exam.hotel.entity.Rooms;
import com.exam.hotel.repository.RoomRepository;
import com.exam.hotel.repository.RoomsRepository;

@Controller
public class RoomController {
	@Autowired
	RoomRepository rrep;
	@Autowired
	RoomsRepository roomsrep;

	static List<String> status = List.of("Vacant", "Occupaid", "Checked-out", "Out-of-order");
	
	String userEmailId;
	@ModelAttribute
	public void posUseremail(Model model) {
		model.addAttribute("user",userEmailId);
	}

	@RequestMapping("/roomCategory/{useremailId}")
	public String roomCategory(@PathVariable("useremailId") String useremailId, Model model) {
		
		userEmailId=useremailId;
		model.addAttribute("user",userEmailId);
		
		List<Room> room = rrep.findAll();
		model.addAttribute("room", room);
		return "user/roomCategory";
	}

	@RequestMapping("/roomCategoryAdd")
	public String roomAddForm() {
		return "user/roomCategoryAdd";
	}

	@PostMapping("/roomCategoryAddProcess")
	public String roomCategoryAdd(@ModelAttribute Room room) {
		rrep.save(room);
		return "redirect:/roomCategory/"+userEmailId;
	}

	@RequestMapping("/roomCategoryUpdateForm/{rId}")
	public String roomUpdate(@PathVariable("rId") int rid, Model model) {
		Room room = rrep.findById(rid).get();
		model.addAttribute("room", room);
		return "user/roomCategoryUpdateForm";
	}

	@PostMapping("/roomCategoryUpdateProcess")
	public String roomCategoryUpdateProcess(@ModelAttribute Room room) {
		rrep.save(room);
		return "redirect:/roomCategory/"+userEmailId;
	}

	@RequestMapping("/roomStatus/{page}")
	public String roomStatus(@PathVariable("page") int page, Model model) {
//		List<Rooms> rooms = roomsrep.findAll();

		Pageable pageable = PageRequest.of(page, 10);
		Page<Rooms> rooms = roomsrep.findAll(pageable);


		model.addAttribute("rooms", rooms);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPage", rooms.getTotalPages());
		return "user/roomStatus";
	}

	@RequestMapping("roomAdd")
	public String roomAdd(Model model) {
		model.addAttribute("room", rrep.findAll());
		model.addAttribute("status", status);
		return "user/roomAdd";
	}

	@PostMapping("/roomAddProcess")
	public String roomAddProcess(@ModelAttribute Rooms rooms) {
		roomsrep.save(rooms);
		return "redirect:/roomStatus/0";
	}

	@RequestMapping("/roomUpdateForm/{rNo}")
	public String roomUpdateForm(@PathVariable("rNo") Integer rNo, Model model) {
		model.addAttribute("rooms", roomsrep.findById(rNo).get());
		model.addAttribute("room", rrep.findAll());
		model.addAttribute("status", status);
		System.out.println(rNo);
		return "user/roomUpdate";
	}

	@PostMapping("/roomUpdateProcess")
	public String roomUpdateProcess(@ModelAttribute Rooms rooms) {
		roomsrep.save(rooms);
		return "redirect:/roomStatus/0";
	}

}

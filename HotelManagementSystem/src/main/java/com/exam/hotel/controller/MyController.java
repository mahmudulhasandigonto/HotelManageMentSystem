package com.exam.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.hotel.entity.PosUser;
import com.exam.hotel.repository.PosUserRepository;

@Controller
public class MyController {
	@Autowired
	PosUserRepository posurep;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/signup")
	public String signup() {

		return "signup";
	}

	@PostMapping("/signupProcess")
	public String signupProcess(@ModelAttribute PosUser posuser, Model model) {
		posurep.save(posuser);
		model.addAttribute("signupMsg"," Information Submitted Successfull !!!");
		return "signup";
	}

	@RequestMapping("/login")
	public String login() {

		return "login";
	}

	@RequestMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("success","Logout Successfully!!");
		return "login";
	}
}

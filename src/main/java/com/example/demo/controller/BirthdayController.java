package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.RegistrationService;

@Controller
@RequestMapping("/birthday")
public class BirthdayController {
	
	@Autowired
	RegistrationService registrationService;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("registration", registrationService.selectAll());
		return "/birthday/index"; // requestmappingでまとめても、returnでは必要
	}
}

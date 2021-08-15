package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.LoginDto;
import com.example.demo.service.DateService;
import com.example.demo.service.LoginService;
import com.example.demo.service.StringToLocalDate;

@Controller
@RequestMapping("/users")
public class SignInController {
	
	@Autowired
	DateService dateService;
	
	@Autowired
	StringToLocalDate stringToLocalDate;
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/login")
	public String loginDisplay() {
		return "users/signin";
	}
	
	@PostMapping("/login")
	public String login(@Validated @ModelAttribute LoginDto loginDto) {
		
		// if文追加
		
		return "birthdayManagement/index";
	}
	
	@GetMapping("/registration")
	public String registrationDisplay(Model model) {
		model.addAttribute("years",dateService.getYears());
		model.addAttribute("months",dateService.getMonths());
		model.addAttribute("dates",dateService.getDates());
		return "users/signup";
	}
	
	@PostMapping("/registration")
	public String registration(@Validated @ModelAttribute LoginDto loginDto) {
		// if文追加する必要あり
		loginDto.setBirthday(stringToLocalDate.stringToLocalDate(loginDto));
		
		loginService.registration(loginDto);
		return "redirect:/users/signin";
	}
}

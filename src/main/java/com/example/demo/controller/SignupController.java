package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UsersDto;
import com.example.demo.dto.validOrder.GroupOrder;
import com.example.demo.service.AgeCalculation;
import com.example.demo.service.EachDateList;
import com.example.demo.service.controllerService.SignService;
import com.example.demo.service.StringToLocalDate;

@Controller
@RequestMapping("/users")
public class SignupController {
	
	@Autowired
	SignService signService;
	
	@Autowired
	EachDateList eachDateList;
	
	@Autowired
	StringToLocalDate stringToLocalDate;
	
	@Autowired
	AgeCalculation ageCalculation;
	
	@GetMapping("/signup")
	public String registrationDisplay(Model model) {
		model.addAttribute("years", eachDateList.getYears());
		model.addAttribute("months", eachDateList.getMonths());
		model.addAttribute("dates", eachDateList.getDates());
		return "users/signup";
	}
	
	@PostMapping("/signup")
	public String signup(@Validated(GroupOrder.class) @ModelAttribute UsersDto usersDto, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) { 
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return registrationDisplay(model);
		}
		//usersDto.setRole("ADMIN");
		usersDto.setRole("GENERAL");
		usersDto.setBirthDate(stringToLocalDate.stringToLocalDate(usersDto));
		usersDto.setAge(ageCalculation.ageCalc(usersDto.getBirthDate()));
		
		signService.signUp(usersDto);
		return "redirect:/users/signin";
	}
}
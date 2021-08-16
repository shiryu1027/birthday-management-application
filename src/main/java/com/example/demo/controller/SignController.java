package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UsersDto;
import com.example.demo.service.AgeCalculation;
import com.example.demo.service.DateService;
import com.example.demo.service.SignService;
import com.example.demo.service.StringToLocalDate;

@Controller
@RequestMapping("/users")
public class SignController {
	
	@Autowired
	SignService signService;
	
	@Autowired
	DateService dateService;
	
	@Autowired
	StringToLocalDate stringToLocalDate;
	
	@Autowired
	AgeCalculation ageCalculation;
	
	// サインイン画面の表示
	@GetMapping("/signin")
	public String signInDisplay() {
		return "users/signin";
	}
	
	// サインイン情報の送信(ログイン)後、ホームぺージに移動
	@PostMapping("/signin")
	public String login(@Validated @ModelAttribute UsersDto usersDto, Model model) {
		
		// if文追加
		
		return "redirect:/birthdayManagement/home";
	}
	
	@GetMapping("/signup")
	public String registrationDisplay(Model model) {
		model.addAttribute("years",dateService.getYears());
		model.addAttribute("months",dateService.getMonths());
		model.addAttribute("dates",dateService.getDates());
		return "users/signup";
	}
	
	@PostMapping("/signup")
	public String signup(@Validated @ModelAttribute UsersDto usersDto) {
		// if文追加する必要あり
		usersDto.setBirthday(stringToLocalDate.stringToLocalDate(usersDto));
		usersDto.setAge(ageCalculation.ageCalc(usersDto.getBirthday()));
		
		signService.signUp(usersDto);
		return "redirect:/users/signin";
	}
}

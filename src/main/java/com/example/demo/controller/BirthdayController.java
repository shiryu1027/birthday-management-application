package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.RegistrationDto;
import com.example.demo.service.RegistrationService;

@Controller
@RequestMapping("/birthday")
public class BirthdayController {
	
	@Autowired
	RegistrationService registrationService;
	
	// ホームぺージ表示
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("registration", registrationService.selectAll());
		return "/birthday/index"; // requestmappingでまとめても、returnでは必要
	}
	
	// 新規情報登録画面の表示
	@GetMapping("/insert")
	public String insertDisplay() {
		return "/birthday/insert";
	}
	
	// 新規情報の登録後、ホームページにリダイレクト
	@PostMapping("/insert")
	public String insert(@ModelAttribute RegistrationDto registrationDto) {
		registrationService.insert(registrationDto);
		return "redirect:/birthday/index";
	}
	
	// 情報更新画面の取得
	@GetMapping("/update/id={id}")
	public String updateDisplay(@PathVariable("id") int id, Model model) { // idだけ必要なら、@PathVariable
		model.addAttribute("registration", registrationService.select(id));
		return "/birthday/update";
	}
	
	// 情報更新後、ホームページへリダイレクト
	@PostMapping("/update/id={id}")
	public String update(@ModelAttribute RegistrationDto registrationDto) { //全てのデータを送るなら、@ModelAttribute
		registrationService.update(registrationDto);
		return "redirect:/birthday/index";
	}
	
	// 情報削除後、ホームページにリダイレクト
	@PostMapping("/delete/id={id}")
	public String delete(@PathVariable("id") int id) {
		registrationService.delete(id);
		return "redirect:/birthday/index";
	}
}

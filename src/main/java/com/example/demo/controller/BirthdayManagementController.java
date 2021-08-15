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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.RegistrationDto;
import com.example.demo.service.DateService;
import com.example.demo.service.RegistrationService;
import com.example.demo.service.StringToLocalDate;

@Controller
@RequestMapping("/birthdayManagement")
public class BirthdayManagementController {
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	DateService dateService;
	
	@Autowired
	StringToLocalDate stringToLocalDate;
	
	// ホームぺージ表示
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("registration", registrationService.selectAll());
		return "/birthdayManagement/home"; // requestmappingでまとめても、returnでは必要
	}
	
	// 新規情報登録画面の表示
	@GetMapping("/insert")
	public String insertDisplay(Model model) {
		model.addAttribute("years",dateService.getYears());
		model.addAttribute("months",dateService.getMonths());
		model.addAttribute("dates",dateService.getDates());
		return "/birthdayManagement/insert";
	}
	
	// 新規情報の登録後、ホームページにリダイレクト
	@PostMapping("/insert")
	public String insert(@Validated @ModelAttribute RegistrationDto registrationDto, BindingResult result, Model model) {
		
		if (result.hasErrors()) { // errorがあるなら・・
			List<String> errorList = new ArrayList<String>(); // errorListを作成(仮説だが、resultの中のエラーメッセージが配列なので、それを直してる？？)
			for (ObjectError error : result.getAllErrors()) { // "result.getAllErrors()"=リスト型、それを拡張for文で取り出し
				errorList.add(error.getDefaultMessage()); // objectErrorのgetDefaultMessage(継承)で、errorのdefaultMessageフィールドを取得。その後、Listに追加
			}
			model.addAttribute("validationError", errorList); // errorListをmodelに流す
			return insertDisplay(model);
		}
		
		// insert前に、birthdayフィールドに変換データをセットする
		registrationDto.setBirthday(stringToLocalDate.stringToLocalDate(registrationDto));
		
		registrationService.insert(registrationDto);
		return "redirect:/birthdayManagement/home";
	}
	
	// 情報更新画面の取得
	@GetMapping("/update/id={id}")
	public String updateDisplay(@PathVariable("id") int id, Model model) { // idだけ必要なら、@PathVariable
		model.addAttribute("registration", registrationService.select(id));
		return "/birthdayManagement/update";
	}
	
	// 情報更新後、ホームページへリダイレクト
	@PostMapping("/update/id={id}")
	public String update(@PathVariable("id") int id, @Validated @ModelAttribute RegistrationDto registrationDto, BindingResult result, Model model) { //全てのデータを送るなら、@ModelAttribute
		
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return updateDisplay(id, model);
		}
		
		registrationService.update(registrationDto);
		return "redirect:/birthdayManagement/home";
	}
	
	// 情報削除後、ホームページにリダイレクト
	@PostMapping("/delete/id={id}")
	public String delete(@PathVariable("id") int id) {
		registrationService.delete(id);
		return "redirect:/birthdayManagement/home";
	}
}

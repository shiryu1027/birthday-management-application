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

import com.example.demo.dto.CelebratedPersonsDto;
import com.example.demo.service.AgeCalculation;
import com.example.demo.service.EachDateList;
import com.example.demo.service.controllerService.BirthdayManagementService;
import com.example.demo.service.StringToLocalDate;

@Controller
@RequestMapping("/birthdayManagement")
public class BirthdayManagementController {
	
	@Autowired
	BirthdayManagementService birthdayManagementService;
	
	@Autowired
	EachDateList eachDateList;
	
	@Autowired
	StringToLocalDate stringToLocalDate;
	
	@Autowired
	AgeCalculation ageCalculation;
	
	// ホームぺージ取得
	@GetMapping("/")
	public String index() {
		return "birthdayManagement/index";
	}
	
	// メインページ取得
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("celebratedPersons", birthdayManagementService.selectAll());
		return "/birthdayManagement/home"; // requestmappingでまとめても、returnでは必要
	}
	
	// 新規情報登録画面の表示
	@GetMapping("/insert")
	public String insertDisplay(Model model) {
		model.addAttribute("years", eachDateList.getYears());
		model.addAttribute("months",eachDateList.getMonths());
		model.addAttribute("dates", eachDateList.getDates());
		return "/birthdayManagement/insert";
	}
	
	// 新規情報の登録後、ホームページにリダイレクト
	@PostMapping("/insert")
	public String insert(@Validated @ModelAttribute CelebratedPersonsDto celebratedPersonsDto, BindingResult result, Model model) {
		
		if (result.hasErrors()) { // errorがあるなら・・
			List<String> errorList = new ArrayList<String>(); // errorListを作成(仮説だが、resultの中のエラーメッセージが配列なので、それを直してる？？)
			for (ObjectError error : result.getAllErrors()) { // "result.getAllErrors()"=リスト型、それを拡張for文で取り出し
				errorList.add(error.getDefaultMessage()); // objectErrorのgetDefaultMessage(継承)で、errorのdefaultMessageフィールドを取得。その後、Listに追加
			}
			model.addAttribute("validationError", errorList); // errorListをmodelに流す
			return insertDisplay(model);
		}
		
		// insert前に、birthdayフィールドに変換データをセットする
		celebratedPersonsDto.setBirthDate(stringToLocalDate.stringToLocalDate(celebratedPersonsDto));
		celebratedPersonsDto.setAge(ageCalculation.ageCalc(celebratedPersonsDto.getBirthDate()));
		birthdayManagementService.insert(celebratedPersonsDto);
		return "redirect:/birthdayManagement/home";
	}
	
	// 情報更新画面の取得
	@GetMapping("/update/id={id}")
	public String updateDisplay(@PathVariable("id") int id, Model model) { // idだけ必要なら、@PathVariable
		model.addAttribute("celebratedPerson", birthdayManagementService.select(id));
		return "/birthdayManagement/update";
	}
	
	// 情報更新後、ホームページへリダイレクト
	@PostMapping("/update/id={id}")
	public String update(@PathVariable("id") int id, @Validated @ModelAttribute CelebratedPersonsDto celebratedPersonsDto, BindingResult result, Model model) { //全てのデータを送るなら、@ModelAttribute
		
		// PathVariableで得たidをDtoにセット
		celebratedPersonsDto.setPersonId(id);
		
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return updateDisplay(id, model);
		}
		
		birthdayManagementService.update(celebratedPersonsDto);
		
		return "redirect:/birthdayManagement/home";
	}
	
	// 情報削除後、ホームページにリダイレクト
	@PostMapping("/birthdayListDelete/id={id}")
	public String birthdayListDString(@PathVariable("id") int id) {
		birthdayManagementService.birthdayListDelete(id);
		return "redirect:/birthdayManagement/home";
	}
}

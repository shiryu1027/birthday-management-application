package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.SignInDto;
import com.example.demo.dto.validOrder.GroupOrder;

@Controller
@RequestMapping("/users")
public class SigninController {

	// サインイン画面の表示
	@GetMapping("/signin")
	public String signInDisplay(Model model) {
		model.addAttribute("notSignin", "");
		return "users/signin";
	}
	
	// サインイン情報の送信(ログイン)後、ホームぺージに移動
	@PostMapping("/signin")
	public String login(@Validated(GroupOrder.class) @ModelAttribute SignInDto signDto, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) { 
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return signInDisplay(model);
		}
		
		return "redirect:/birthdayManagement/home";
	}
	
	
}

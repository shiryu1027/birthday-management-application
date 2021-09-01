package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.controllerService.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	// アドミン管理画面表示
	@GetMapping("/admin")
	public String adminDisplay(Model model) {
		model.addAttribute("users", adminService.selectAll());
		return "admin/admin";
	}
	
	@PostMapping("/delete/id={id}")
	public String deleteUser(@PathVariable("id") int id) {
		adminService.deleteUser(id);
		return "redirect:/admin/admin";
	}
	
}

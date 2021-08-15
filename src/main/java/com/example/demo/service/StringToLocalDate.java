package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.RegistrationDto;

@Service
public class StringToLocalDate {
	
	// String型のyear,month,dateを、LocalDate型のbirthdayに代入
	public LocalDate stringToLocalDate(RegistrationDto registrationDto) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		if (registrationDto.getMonth().length() == 1) {
			registrationDto.setMonth(0 + registrationDto.getMonth());
		}
		
		if (registrationDto.getDate().length() == 1) {
			registrationDto.setDate(0 + registrationDto.getDate());
		}
		
		LocalDate localDate = LocalDate.parse(registrationDto.getYear() + "/" + registrationDto.getMonth() + "/" + registrationDto.getDate(), fmt);
		
		return localDate;
	}
	
	public LocalDate stringToLocalDate(LoginDto loginDto) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		if (loginDto.getMonth().length() == 1) {
			loginDto.setMonth(0 + loginDto.getMonth());
		}
		
		if (loginDto.getDate().length() == 1) {
			loginDto.setDate(0 + loginDto.getDate());
		}
		
		LocalDate localDate = LocalDate.parse(loginDto.getYear() + "/" + loginDto.getMonth() + "/" + loginDto.getDate(), fmt);
		
		return localDate;
	}
	
}

package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UsersDto;
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
	
	public LocalDate stringToLocalDate(UsersDto usersDto) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		if (usersDto.getMonth().length() == 1) {
			usersDto.setMonth(0 + usersDto.getMonth());
		}
		
		if (usersDto.getDate().length() == 1) {
			usersDto.setDate(0 + usersDto.getDate());
		}
		
		LocalDate localDate = LocalDate.parse(usersDto.getYear() + "/" + usersDto.getMonth() + "/" + usersDto.getDate(), fmt);
		
		return localDate;
	}
	
}

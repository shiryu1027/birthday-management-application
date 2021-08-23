package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UsersDto;
import com.example.demo.dto.CelebratedPersonsDto;

@Service
public class StringToLocalDate {
	
	// String型のyear,month,dateを、LocalDate型のbirthdayに代入
	public LocalDate stringToLocalDate(CelebratedPersonsDto celebratedPersonsDto) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		if (celebratedPersonsDto.getMonth().length() == 1) {
			celebratedPersonsDto.setMonth(0 + celebratedPersonsDto.getMonth());
		}
		
		if (celebratedPersonsDto.getDate().length() == 1) {
			celebratedPersonsDto.setDate(0 + celebratedPersonsDto.getDate());
		}
		
		LocalDate localDate = LocalDate.parse(celebratedPersonsDto.getYear() + "/" + celebratedPersonsDto.getMonth() + "/" + celebratedPersonsDto.getDate(), fmt);
		
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

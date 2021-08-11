package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RegistrationDto {
	private int id;
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd") //input type="date"で入力する場合、どのような形式で代入されるかを指定する必要がある。
	private LocalDate birthday;
	
	private int age;
	private String relationship;
}

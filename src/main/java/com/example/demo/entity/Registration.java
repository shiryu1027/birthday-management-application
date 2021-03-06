package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Registration {
	private int id;
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthday;
	private int age;
	private String relationship;
}

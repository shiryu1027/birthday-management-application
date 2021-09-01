package com.example.demo.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Users {
	
	private int userId;
	
	private String mailAddress;
	
	private String password;
	
	private String name;
	
	private String year;
	
	private String month;
	
	private String date;
	
	private LocalDate birthDate;
	
	private int age;
	
	private String role;
}

package com.example.demo.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Users {
	
	private int id;
	
	private String mailAdress;
	
	private String password;
	
	private String name;
	
	private String year;
	
	private String month;
	
	private String date;
	
	private LocalDate birthday;
	
	private int age;
}

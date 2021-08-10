package com.example.demo.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Registration {
	private String name;
	private LocalDate birthday;
	private int age;
	private String relationship;
}

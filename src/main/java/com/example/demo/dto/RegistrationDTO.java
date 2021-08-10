package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RegistrationDTO {
	private String name;
	private LocalDate birthday;
	private int age;
	private String relationship;
}

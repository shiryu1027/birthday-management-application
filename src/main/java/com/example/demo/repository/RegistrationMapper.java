package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.RegistrationDto;
import com.example.demo.entity.Registration;

@Mapper
public interface RegistrationMapper {
	
	Registration select(int id);
	
	List<Registration> selectAll();
	
	void insert(RegistrationDto registrationDto);
	
	void update(RegistrationDto registrationDto);
	
	void delete(int id);
}

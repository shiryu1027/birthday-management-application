package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Registration;

@Mapper
public interface RegistrationMapper {
	
	List<Registration> selectAll();
}

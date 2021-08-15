package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.LoginDto;

@Mapper
public interface LoginMapper {
	
	void registration(LoginDto loginDto);
	
}

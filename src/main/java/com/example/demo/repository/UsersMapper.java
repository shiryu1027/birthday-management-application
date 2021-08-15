package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UsersDto;

@Mapper
public interface UsersMapper {
	
	void signUp(UsersDto usersDto);
	
}

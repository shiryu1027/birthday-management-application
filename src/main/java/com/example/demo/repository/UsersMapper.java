package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UsersDto;
import com.example.demo.entity.Users;

@Mapper
public interface UsersMapper {
	
	void signUp(UsersDto usersDto);
	
	List<Users> selectAll();
	
	void delete(int userId);
	
	/*ログインユーザー取得*/
	Users findLoginUser(String mailAddress);
	
}

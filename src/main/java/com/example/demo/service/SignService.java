package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsersDto;
import com.example.demo.repository.UsersMapper;

@Service
public class SignService {
	
	@Autowired
	UsersMapper usersMapper;
	
	//ユーザー新規登録(signup)
	public void signUp(UsersDto usersDto) {
		usersMapper.signUp(usersDto);
	}
}

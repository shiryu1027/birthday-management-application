package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDto;
import com.example.demo.repository.LoginMapper;

@Service
public class LoginService {
	
	@Autowired
	LoginMapper loginMapper;
	
	public void registration(LoginDto loginDto) {
		loginMapper.registration(loginDto);
	}
}

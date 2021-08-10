package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Registration;
import com.example.demo.repository.RegistrationMapper;

@Service
public class RegistrationService {
	
	@Autowired
	RegistrationMapper registrationMapper;
	
	//登録情報全件取得
	public List<Registration> selectAll() {
		return registrationMapper.selectAll();
	}
}

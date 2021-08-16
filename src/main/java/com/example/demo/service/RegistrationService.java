package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegistrationDto;
import com.example.demo.entity.Registration;
import com.example.demo.repository.RegistrationMapper;

@Service
public class RegistrationService {
	
	@Autowired
	RegistrationMapper registrationMapper;
	
	// 登録情報1件取得
	public Registration select(int id) {
		return registrationMapper.select(id);
	}
	
	//登録情報全件取得
	public List<Registration> selectAll() {
		return registrationMapper.selectAll();
	}
	
	//新規情報登録
	public void insert(RegistrationDto registrationDto) {
		registrationMapper.insert(registrationDto);
	}
	
	//登録情報更新
	public void update(RegistrationDto registrationDto) {
		registrationMapper.update(registrationDto);
	}
	
	//登録情報削除
	public void birthdayListDelete(int id) {
		registrationMapper.birthdayListDelete(id);
	}
}

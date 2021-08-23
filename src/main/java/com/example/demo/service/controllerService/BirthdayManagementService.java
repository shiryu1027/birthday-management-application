package com.example.demo.service.controllerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CelebratedPersonsDto;
import com.example.demo.entity.CelebratedPersons;
import com.example.demo.repository.CelebratedPersonsMapper;

@Service
public class BirthdayManagementService {
	
	@Autowired
	CelebratedPersonsMapper celebratedPersonsMapper;
	
	// 登録情報1件取得
	public CelebratedPersons select(int personId) {
		return celebratedPersonsMapper.select(personId);
	}
	
	//登録情報全件取得
	public List<CelebratedPersons> selectAll() {
		return celebratedPersonsMapper.selectAll();
	}
	
	//新規情報登録
	public void insert(CelebratedPersonsDto celebratedPersonsDto) {
		celebratedPersonsMapper.insert(celebratedPersonsDto);
	}
	
	//登録情報更新
	public void update(CelebratedPersonsDto celebratedPersonsDto) {
		celebratedPersonsMapper.update(celebratedPersonsDto);
	}
	
	//登録情報削除
	public void birthdayListDelete(int personId) {
		celebratedPersonsMapper.birthdayListDelete(personId);
	}
}

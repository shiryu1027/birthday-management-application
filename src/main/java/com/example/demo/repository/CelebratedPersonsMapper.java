package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.CelebratedPersonsDto;
import com.example.demo.entity.CelebratedPersons;

@Mapper
public interface CelebratedPersonsMapper {
	
	CelebratedPersons select(int PersonId);
	
	List<CelebratedPersons> selectAll();
	
	void insert(CelebratedPersonsDto celebratedPersonsDto);
	
	void update(CelebratedPersonsDto celebratedPersonsDto);
	
	void birthdayListDelete(int PersonId);
}

package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class AgeCalculation {
	
	public int ageCalc(LocalDate birthday) {
		// 1.[現在年ー生まれ年]により基準となる年齢を計算する。
		LocalDate localDate = LocalDate.now(); // 現在年月日
		int localDateYear = localDate.getYear(); // 現在年
		int birthdayYear = birthday.getYear(); // 生まれ年
		
		int Age = localDateYear - birthdayYear;
		
		// 2.今年誕生日を迎えているかを判断する。
		int localDateMonth = localDate.getMonthValue();
		int birthdayMonth = birthday.getMonthValue();
		int localDateDate = localDate.getDayOfMonth();
		int birthdayDate = birthday.getDayOfMonth();
		
		// 2-1.[現在月 < 誕生月]であれば年齢を−１する。
		if(localDateMonth < birthdayMonth) {
			Age--;
		}
		
		//2-2.[現在月 = 誕生月]ではあるが[現在日 < 誕生日]であれば年齢−１する。
		if (localDateMonth == birthdayMonth && localDateDate < birthdayDate) {
			Age--;
		}
		
		return Age;
	}
	
}

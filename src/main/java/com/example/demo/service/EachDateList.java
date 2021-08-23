package com.example.demo.service;

import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class EachDateList {
	
	private Set<Integer> years;
	private Set<Integer> months;
	private Set<Integer> dates;
	
	public EachDateList() {
		
		// years
		Set<Integer> years = new LinkedHashSet<>();
		Year year = Year.now();
		
		for (int i = year.getValue(); i >= year.getValue() - 120; i--) {
			years.add(i);
		}
		
		this.years = years;
		
		// months
		Set<Integer> months = new LinkedHashSet<>();
		
		for (int i = 1; i <= 12; i++) {
			months.add(i);
		}
		
		this.months = months;
		
		// dates
		Set<Integer> dates = new LinkedHashSet<>();
		
		for (int i = 1; i <= 31; i++) {
			dates.add(i);
		}
		
		this.dates = dates;
	}

	public Set<Integer> getMonths() {
		return months;
	}

	public Set<Integer> getDates() {
		return dates;
	}

	public Set<Integer> getYears() {
		return years;
	}
	
	
	
	
}

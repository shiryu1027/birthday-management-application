package com.example.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RegistrationDto {
	
	private int id;
	
	@NotBlank(message="名前は必須入力です") // messageでエラーメッセージを指定できる
	@Pattern(regexp=".*\s.*", message="名前の間に半角スペースを入れてください")
	private String name;
	
	@NotNull(message="誕生日は必須入力です")
	@DateTimeFormat(pattern="yyyy-MM-dd") //input type="date"で入力する場合、どのような形式で代入されるかを指定する必要がある。
	private LocalDate birthday;
	
	@Max(value=130, message="年齢には130以下を入力して下さい")
	@Min(value=0, message="年齢には正の値を入力して下さい")
	private int age;
	
	@NotBlank(message="関係性は必須入力です")
	private String relationship;
}

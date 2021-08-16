package com.example.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UsersDto {
	
	private int id;
	
	@Email(message="メードアドレス形式で入力して下さい")
	@NotBlank(message="メールアドレスは必須入力です")
	private String mailAdress;
	
	@NotBlank(message="パスワードは必須入力です")
	private String password;
	
	@NotBlank(message="名前は必須入力です")
	@Pattern(regexp=".*\s.*", message="名前の間に半角スペースを入れてください")
	private String name;
	
	private String year;
	
	private String month;
	
	private String date;
	
	private LocalDate birthday;
	
	@Max(value=130, message="年齢には130以下を入力して下さい")
	@Min(value=0, message="年齢には正の値を入力して下さい")
	private int age;
}

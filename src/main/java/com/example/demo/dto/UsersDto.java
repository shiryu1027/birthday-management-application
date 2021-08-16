package com.example.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.example.demo.dto.validOrder.ValidGroup1;
import com.example.demo.dto.validOrder.ValidGroup2;

import lombok.Data;

@Data
public class UsersDto {
	
	private int id;
	
	@Email(message="メードアドレス形式で入力して下さい")
	@NotBlank(message="メールアドレスは必須入力です", groups=ValidGroup1.class)
	private String mailAdress;
	
	@NotBlank(message="パスワードは必須入力です", groups=ValidGroup1.class)
	private String password;
	
	@NotBlank(message="名前は必須入力です", groups=ValidGroup1.class)
	@Pattern(regexp=".*\s.*", message="名前の間に半角スペースを入れてください", groups=ValidGroup2.class)
	private String name;
	
	private String year;
	
	private String month;
	
	private String date;
	
	private LocalDate birthday;
	
	@Max(value=130, message="年齢には130以下を入力して下さい")
	@Min(value=0, message="年齢には正の値を入力して下さい")
	private int age;
}

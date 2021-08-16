package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SignInDto {
	
	@Email(message="メードアドレス形式で入力して下さい")
	@NotBlank(message="メールアドレスは必須入力です")
	private String mailAdress;
	
	@NotBlank(message="パスワードは必須入力です")
	private String password;
}

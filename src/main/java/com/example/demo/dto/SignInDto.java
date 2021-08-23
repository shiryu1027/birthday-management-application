package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.example.demo.dto.validOrder.ValidGroup1;
import com.example.demo.dto.validOrder.ValidGroup2;

import lombok.Data;

@Data
public class SignInDto {
	
	@Email(message="メードアドレス形式で入力して下さい", groups=ValidGroup2.class) //type="Emailにすると、これがいらなくなる　→　Chromeだと自動
	@NotBlank(message="メールアドレスは必須入力です", groups=ValidGroup1.class)
	private String mailAddress;
	
	@NotBlank(message="パスワードは必須入力です", groups=ValidGroup1.class)
	private String password;
}

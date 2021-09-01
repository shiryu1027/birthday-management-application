package com.example.demo.service.controllerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsersDto;
import com.example.demo.entity.Users;
import com.example.demo.repository.UsersMapper;

@Service
public class SignService {
	
	@Autowired
	UsersMapper usersMapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	//ユーザー新規登録(insert)
	public void signUp(UsersDto usersDto) {
		
		// パスワード暗号化
        String rawPassword = usersDto.getPassword();
        usersDto.setPassword(encoder.encode(rawPassword));
		
		usersMapper.signUp(usersDto);
	}
	
	// ログインユーザー情報取得
	public Users getLoginUser(String mailAddress) {
		return usersMapper.findLoginUser(mailAddress);
	}
	
}

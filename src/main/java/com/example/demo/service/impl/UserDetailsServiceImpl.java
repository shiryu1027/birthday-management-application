package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.service.controllerService.SignService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private SignService signService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// ユーザー情報取得
		Users signinUser  = signService.getLoginUser(username); //user
		
		// ユーザーが存在しない場合
		if(signinUser == null) {
			throw new UsernameNotFoundException("user not found");
		}
		
		// 権限List作成
		GrantedAuthority authority = new SimpleGrantedAuthority(signinUser.getRole());
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(authority);
		
		// UserDetails生成
		UserDetails userDetails = (UserDetails) new User(signinUser.getMailAddress(), signinUser.getPassword(), authorities);
		
		return userDetails;
	}
	
}

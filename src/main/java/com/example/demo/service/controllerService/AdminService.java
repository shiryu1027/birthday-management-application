package com.example.demo.service.controllerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersMapper;

@Service
public class AdminService {
	
	@Autowired
	UsersMapper usersMapper;
	
	public List<Users> selectAll() {
		return usersMapper.selectAll();
	}
	
	public void deleteUser(int userId) {
		usersMapper.delete(userId);
	}
	
}

package com.springbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;


@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO; 
	
	// Setter 인젝션 처리를 위한 Setter 메소드 추가 
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO; 
	}
	
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
	
}

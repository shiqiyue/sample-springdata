package com.wwy.sample.springdata.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwy.sample.springdata.dao.UserDao;
import com.wwy.sample.springdata.entity.User;

@Service
public class UserService {

	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	public void addUser(User user){
		user = userDao.save(user);
		if (user != null){
			log.info("add user succ");
		}else{
			log.info("add user fail");
		}
	}
	
	public User findById(Long Id){
		return userDao.findOne(Id);
	}
	
}

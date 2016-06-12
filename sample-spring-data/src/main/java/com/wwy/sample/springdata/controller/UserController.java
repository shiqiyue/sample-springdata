package com.wwy.sample.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwy.sample.springdata.entity.User;
import com.wwy.sample.springdata.entity.User.Sex;
import com.wwy.sample.springdata.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("add")
	@ResponseBody
	public String addUser (){
		User user = new User();
		user.setUsername("username1");
		user.setPassword("password1");
		user.setMobileno("1528042");
		user.setSalt("dasdas");
		user.setSex(Sex.female);
		userService.addUser(user);
		return "succ";
	}
	
	@RequestMapping("find")
	@ResponseBody
	public User user(){
		return userService.findById(10030L);
	}
}

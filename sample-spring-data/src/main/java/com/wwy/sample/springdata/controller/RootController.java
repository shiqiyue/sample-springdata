package com.wwy.sample.springdata.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {

	@RequestMapping("/")
	public String main() {
		return "main";
	}
}

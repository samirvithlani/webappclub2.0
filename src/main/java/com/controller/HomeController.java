package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/addHome")
	public String add() {

		System.out.println("home..");

		return "redirect:/view"; // home.jsp
	}
	@RequestMapping("/view")
	public String view() {

		System.out.println("view");
		return "home";// home.jsp
	}
}

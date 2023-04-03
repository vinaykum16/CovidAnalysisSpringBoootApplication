package com.covid_analysis.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.covid_analysis.entity.User;
import com.covid_analysis.services.ActiveUserService;

@Controller
public class ActiveUserController {

	@Autowired
	private ActiveUserService auService;

	@GetMapping("/loggedUsers")
	public String getLoggedUsers(Locale locale, Model model4) {
		List<User> userList = auService.getAllUsers();
		model4.addAttribute("personList", userList);
		return "loggedUsers";
	}

}

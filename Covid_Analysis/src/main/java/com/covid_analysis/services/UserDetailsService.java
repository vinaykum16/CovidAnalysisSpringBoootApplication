package com.covid_analysis.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.covid_analysis.entity.User;

@Service
public class UserDetailsService {

	private static List<User> users = new ArrayList<>();

	public UserDetailsService() {
		users.add(new User("Sonu", "123", "user"));
		users.add(new User("Monu", "123", "Admin"));
		users.add(new User("Kaalu", "123", "user"));
		users.add(new User("Peelu", "123", "user"));
		users.add(new User("Neelu", "123", "admin"));
		users.add(new User("Golu", "123", "admin"));
	}

}

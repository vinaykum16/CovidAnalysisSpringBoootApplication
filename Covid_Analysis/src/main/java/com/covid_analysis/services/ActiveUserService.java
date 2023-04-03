package com.covid_analysis.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.covid_analysis.entity.User;

@Service
public class ActiveUserService {

	List<User> users = new ArrayList<>();

	public ActiveUserService activeUserStore() {
		return new ActiveUserService();
	}

	public int addUser(@RequestBody User user) {
		this.users.add(user);
		return 1;
	}

	public int addNewUser(User user) {
		if (!this.users.contains(user))
			this.users.add(user);
		return 1;
	}

	public int addUser(String name, String password, String role) {
		User tempUser = new User();
		tempUser.setName(name);
		tempUser.setPassword(password);
		tempUser.setRole(role);

		this.users.add(tempUser);
		return 1;
	}

	public void addUserList(List<User> allUsers) {
		this.users = allUsers;
	}

	public User getUserByName(String name) {
		User tempUser = new User();
		for (User user : this.users) {
			if (user.getName().equals(name)) {
				System.out.println("Inside ActiveUser::getSpecificUserByUsername");
				System.out.println(user.getName() + " " + user.getPassword() + " " + user.getRole());
				tempUser.setName(user.getName());
				tempUser.setPassword(user.getPassword());
				tempUser.setRole(user.getRole());
			}
		}

		return tempUser;
	}

	public List<User> getAllUsers() {
		return this.users;
	}

	public void deleteUserByName(String name) {
		User user = getUserByName(name);
		this.users.remove(user);
	}

}

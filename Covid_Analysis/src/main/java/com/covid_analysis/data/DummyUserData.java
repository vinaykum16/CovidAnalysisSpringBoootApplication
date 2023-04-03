package com.covid_analysis.data;

import com.covid_analysis.entity.User;
import com.covid_analysis.services.ActiveUserService;

public class DummyUserData {

	private ActiveUserService dummyData;

	public void addDummyUserData() {
		this.dummyData.addUser(new User("Baby", "MereBaabu", "admin"));
		this.dummyData.addUser(new User("Baabu", "NeThana", "user"));
		this.dummyData.addUser(new User("Jaanu", "Khaya", "admin"));
		this.dummyData.addUser(new User("Sona", "Laddu", "user"));
		this.dummyData.addUser(new User("Bachha", "mno", "user"));
		this.dummyData.addUser(new User("Kaalu", "pqr", "user"));
		this.dummyData.addUser(new User("Golu", "stu", "user"));
		this.dummyData.addUser(new User("Sonu", "uvx", "user"));
		this.dummyData.addUser(new User("Monu", "xyz", "admin"));
		this.dummyData.addUser(new User("Munni", "123", "user"));
		this.dummyData.addUser(new User("Seela", "jkk", "admin"));
		this.dummyData.addUser(new User("Roopa", "mela", "admin"));
		this.dummyData.addUser(new User("Gujjar", "mela", "admin"));

		System.out.println("Inside ActiveUserStore::getSpecificUser");
		this.dummyData.getUserByName("Monu");
		System.out.println("Dummy User Data");
	}

}

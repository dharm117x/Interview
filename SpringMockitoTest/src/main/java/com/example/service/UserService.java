package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.data.User;

@Service
public class UserService {

	List<User> users = new ArrayList<>();
	
	UserService() {
		users.add(new User("SK", "SK@g.com", "1111111"));
		users.add(new User("DK", "DK@g.com", "1111111"));
	}
	
	public void create(User user) {
		users.add(user);
	}
	
	public void create(List<User> users) {
		users.addAll(users);
	}

	public User findFirstUser() {
		return users.get(0);
	}
	
	public List<User> findAllUsers() {
		return users;
	}

	public List<User> findByName(String name) {
		return users.stream().filter(f-> name.equals(f.getName())).collect(Collectors.toList());
	}
}

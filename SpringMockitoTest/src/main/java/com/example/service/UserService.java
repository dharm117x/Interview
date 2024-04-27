package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.data.User;

@Service
public class UserService {

	List<User> data = new ArrayList<>();
	
	public void create(User user) {
		data.add(user);
	}
	
	public void create(List<User> users) {
		data.addAll(users);
	}

	public List<User> findAllUsers() {
		return data;
	}

	public List<User> findByName(String name) {
		data.add(new User("SK", "SK@g.com", "1111111"));		
		return data.stream().filter(f-> name.equals(f.getName())).collect(Collectors.toList());
	}
}

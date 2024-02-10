package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.beans.UserData;

@Service("userService")
public class DefaultUserService implements UserDetailsService{
	List<UserData> data = new ArrayList<>();
	
	public List<UserData> findAll() {
		return data;
	}

	public UserData save(UserData user) {
		data.add(user);
		return user;
	}

	public void delete(Long id) {
		data.remove(0);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserData user = data.stream().filter(u->u.getUsername().equals(username)).findFirst().orElseThrow();
		return user;
	}

}

package com.example;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.example.data.User;
import com.example.service.UserService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceUnitTest {
	
	@InjectMocks
	UserService service;
	
	@Mock
	User user;
	
	@Mock
	List<User> users;

	@Mock
	Stream<User> stream;
	
	@Test
	public void test_getallUsers() {
		when(users.get(anyInt())).thenReturn(user);
		when(user.getName()).thenReturn("DK");
		List<User> users = service.findAllUsers();
		assertEquals(users, users);
	}
	

	@Test
	public void test_FindByName() {
		String name = "SK";
		when(users.stream().filter(f-> name.equals(f.getName()))).thenReturn(stream);
		when(stream.collect(Collectors.toList())).thenReturn(users);
		
		List<User> list = service.findByName(name);
		assertEquals(list.size(), users.size());
	}
}

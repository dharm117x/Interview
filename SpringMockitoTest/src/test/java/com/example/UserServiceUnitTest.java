package com.example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.example.data.User;
import com.example.service.UserService;

import sun.awt.SunHints.Value;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceUnitTest {
	
	@InjectMocks
	UserService service;
	
	@Mock
	User user;
	
	@Mock
	List<User> users;
	
	@BeforeEach
	public void setup() {
		System.out.println("UserServiceUnitTest.setup()");
		User usr = new User("DK", "Dk@g.com","111111");
		//service.create(usr);	
	}
	
	@Test
	public void test_getallUsers() {
		when(users.size()).thenReturn(5);
		List<User> result = service.findAllUsers();
		assertEquals(result.size(), users.size());
	}
	
	@Test
	public void test_create() {
		User usr = new User("VK", "Dk@g.com","111111");
		ArgumentCaptor<User> argCaptor = ArgumentCaptor.forClass(User.class);
		service.create(usr);

		verify(users).add(argCaptor.capture());
		assertEquals("VK", argCaptor.getValue().getName());
	}
	
	@Test
	public void test_findOne() {
		when(user.getName()).thenReturn("DK");
		when(users.get(0)).thenReturn(user);
		
		User user = service.findFirstUser();
		assertThat(user.getName(), is(user.getName()));
	}
	
	@Test
	public void test_findbyName() {
		Stream<User> stream = mock(Stream.class);

		when(user.getName()).thenReturn("DK");
		when(users.get(0)).thenReturn(user);
		when(users.stream().filter(f-> "DK".equals(f.getName()))).thenReturn(stream);
		when(stream.collect(Collectors.toList())).thenReturn(users);
		
		List<User> list = service.findByName("DK");
		assertThat(list.get(0).getName(), is(user.getName()));
	}
}

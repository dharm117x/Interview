package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MocitoMockTest {

	@Mock
	List<String> mockList;

	@BeforeEach
	public void setup() {
		System.out.println("MocitoMockTest.setup()");
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void test() {
		List<String> mockList = mock(List.class);
		when(mockList.size()).thenReturn(5);
		assertTrue(mockList.size()==5);
	}
	
	@Test
	public void test_1() {
		when(mockList.get(0)).thenReturn("JournalDev");
		assertEquals("JournalDev", mockList.get(0));
	}
	
	@Test
	public void test_2() {
		mockList.add("one");
		ArgumentCaptor<String> argCaptor = ArgumentCaptor.forClass(String.class);
	    Mockito.verify(mockList).add(argCaptor.capture());

	    assertEquals("one", argCaptor.getValue());
	}
}

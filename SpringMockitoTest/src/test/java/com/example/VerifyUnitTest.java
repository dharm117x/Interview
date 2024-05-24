package com.example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.example.test.MyList;

public class VerifyUnitTest {

	@Test
	public void test_noIntraction() {
		List<String> mockedList = mock(MyList.class);
		verify(mockedList, times(0)).size();
	}
	
	@Test
	public void test_Verifylist() {
		List<String> mockedList = mock(MyList.class);
		mockedList.size();
		mockedList.add("Hello World");
		
		verify(mockedList, times(1)).size();
		verify(mockedList).add("Hello World");
		verify(mockedList, never()).clear();
	}

	@Test
	public void test_argumentCapture() {
		List<String> mockedList = mock(MyList.class);
		mockedList.addAll(Arrays.asList("someElement"));

		ArgumentCaptor<List<String>> argumentCaptor = ArgumentCaptor.forClass(List.class);
		verify(mockedList).addAll(argumentCaptor.capture());

		List<String> capturedArgument = argumentCaptor.getValue();
		assertThat(capturedArgument.get(0), is("someElement"));
	}
}

package com.example.server;

import java.time.LocalDateTime;

import com.example.shared.MessageService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class MessageServiceImpl extends RemoteServiceServlet implements MessageService {
	private static final long serialVersionUID = 1L;

	public String sendMessage(String message) throws IllegalArgumentException {
		if (message == null) {
			throw new IllegalArgumentException("message is null");
		}

		return "Hello, " + message + "!<br><br> Time received: " + LocalDateTime.now();
	}
}
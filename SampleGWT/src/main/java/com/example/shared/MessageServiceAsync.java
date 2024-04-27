package com.example.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MessageServiceAsync {
	void sendMessage(String input, AsyncCallback<String> callback) throws IllegalArgumentException;
}
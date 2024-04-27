package com.example.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("greet")
public interface MessageService extends RemoteService {
    String sendMessage(String message) throws IllegalArgumentException;
}
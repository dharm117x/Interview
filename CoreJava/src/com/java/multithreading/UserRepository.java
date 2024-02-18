package com.java.multithreading;

import java.util.UUID;

public class UserRepository {

	String getUserNameForUserId(Integer userId) {
        return UUID.randomUUID().toString();
    }
}
package com.example.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserStore implements HttpSessionBindingListener {

	private String username;
	private boolean alreadyLoggedIn;
	private static Map<UserStore, HttpSession> logins = new HashMap<UserStore, HttpSession>();

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAlreadyLoggedIn() {
		return alreadyLoggedIn;
	}

	public void setAlreadyLoggedIn(boolean alreadyLoggedIn) {
		this.alreadyLoggedIn = alreadyLoggedIn;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		HttpSession oldSession = logins.get(this);
	    if (oldSession != null) {
	      alreadyLoggedIn = true;
	    } else {
	      logins.put(this, event.getSession());
	    }
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		logins.remove(this);
		event.getSession().invalidate();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserStore other = (UserStore) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserStore [accountId=" + username + "]";
	}
	
} 
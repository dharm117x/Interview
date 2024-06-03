package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

	List<String> usersNamesList = new ArrayList<String>();

	@Autowired
	private SessionRegistry sessionRegistry;
	
	@GetMapping({"login","/"})
	public String loginPage() {
		
		return "loginPage";
	}
	
	@RequestMapping("home")
	public String homePage( ModelMap map) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(map.put("username", authentication.getPrincipal()));
		List<Object> principals = sessionRegistry.getAllPrincipals();

		for (Object principal: principals) {
		    if (principal instanceof User) {
		        usersNamesList.add(((User) principal).getUsername());
		    }
		}
		System.out.println("User:: "+usersNamesList);
		map.put("usersNamesList", usersNamesList);
		return "homePage";
	}
	
	@RequestMapping("invalidate")
	public String destroySession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null)
			session.invalidate();
		
		return "invalidSessionPage";
	}
	
}

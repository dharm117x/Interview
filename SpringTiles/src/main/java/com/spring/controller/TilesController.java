package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TilesController {
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		System.out.println("TilesController.homePage()");
		return "home";
	}


	@RequestMapping(value = { "/contacts" }, method = RequestMethod.GET)
	public String contactUsPage(ModelMap model) {
		System.out.println("TilesController.contactUsPage()");
		return "contact";
	}
}
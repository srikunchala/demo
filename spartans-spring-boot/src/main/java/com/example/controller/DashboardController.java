package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.UserN;
 

@Controller
public class DashboardController {
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("welcome");
    	return model;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
    	ModelAndView model = new ModelAndView();
    	model.addObject("users", getUsers());
    	model.setViewName("dashboard");
    	return model;
    }

	private List<UserN> getUsers() {
		UserN user = new UserN();
		user.setEmail("johndoe123@gmail.com");
		user.setName("John Doe");
		user.setAddress("Bangalore, Karnataka");
		UserN user1 = new UserN();
		user1.setEmail("amitsingh@yahoo.com");
		user1.setName("Amit Singh");
		user1.setAddress("Chennai, Tamilnadu");
		UserN user2 = new UserN();
		user2.setEmail("bipulkumar@gmail.com");
		user2.setName("Bipul Kumar");
		user2.setAddress("Bangalore, Karnataka");
		UserN user3 = new UserN();
		user3.setEmail("prakashranjan@gmail.com");
		user3.setName("Prakash Ranjan");
		user3.setAddress("Chennai, Tamilnadu");
		return Arrays.asList(user, user1, user2, user3);
	}

}

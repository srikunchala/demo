package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.service.UserService;


@Controller
public class StudentController {
	
	@Autowired
	private UserService userService;
	
	
//	@RequestMapping(path="/", method=RequestMethod.GET)
//	public String goHome(){
//		return "index";
//	}
	
	@RequestMapping(path="/list", method=RequestMethod.GET)
	public String goloadstudentdata(){
		return "list";
	}
	
	@RequestMapping(path="/chartdrilldown", method=RequestMethod.GET)
	public String goloadschartdrilldown(){
		return "chartdrilldown";
	}
	
	@RequestMapping(path="/drilldowndemochart", method=RequestMethod.GET)
	public String drilldowndemochart(){
		return "drilldowndemochart";
	} 
	
//	@RequestMapping(path="/grid", method=RequestMethod.GET)
//	public String gogrid(){
//		return "grid";
//	}
	
	
	@RequestMapping(value="/grid", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("grid");
		return modelAndView;
	}
	
	
	@RequestMapping(path="/chart", method=RequestMethod.GET)
	public String goloadstudentdata1(){
		return "chart";
	}
	
	@RequestMapping(path="/monthlydrillchart", method=RequestMethod.GET)
	public String monthlyDrilldownChart(){
		return "monthlydrilldownchart";
	}
	
	
	
	@RequestMapping("/partials/{page}")
	String partialHandler(@PathVariable("page") final String page) {
		return page;
	}
	
	

}

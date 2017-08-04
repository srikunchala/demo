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
public class ChartController {
	
	@Autowired
	private UserService userService;
	
	
//	@RequestMapping(path="/", method=RequestMethod.GET)
//	public String goHome(){
//		return "index";
//	}
	
	@RequestMapping(path="/studchartline", method=RequestMethod.GET)
	public String goloadstudentdata(){
		return "studchartline";
	}
	
	@RequestMapping(path="/studchartbar", method=RequestMethod.GET)
	public String goloadstudentbar(){
		return "studchartbar";
	}
	 
	

}

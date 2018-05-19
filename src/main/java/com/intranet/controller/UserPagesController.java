package com.intranet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intranet.model.User;
import com.intranet.service.UserService;

@Controller
public class UserPagesController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/user/index", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//		User user = userService.findUserByEmail(auth.getName());
		//		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ") with user role " + user.getRoles().iterator().next().getRole() );
		//		modelAndView.addObject("userMessage","Content Available Only for Users with User Role");
		modelAndView.setViewName("user/index");
		return modelAndView;
	}

	@RequestMapping(value="/user/tables", method = RequestMethod.GET)
	public ModelAndView tables(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/tables");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/index", method = RequestMethod.GET)
	public ModelAndView admin(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ") with user role " + user.getRoles().iterator().next().getRole() );
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/index");
		return modelAndView;
	}
	
}

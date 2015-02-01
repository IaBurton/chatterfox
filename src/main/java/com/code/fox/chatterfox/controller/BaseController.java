package com.code.fox.chatterfox.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.code.fox.chatterfox.data.AnonUser;
import com.code.fox.chatterfox.data.provider.AnonManager;

@RestController
public class BaseController {
	
	@Autowired
	private AnonManager anonManager;
	
	//tried redirecting page here instead of else where by returning a modelandview
	//successfully returned modelandview when the login was bad
	//but couldn't redirect within context of user from here as well (passing user object vs username)
	//needs work
	@RequestMapping(value = "/login/anon/", method = RequestMethod.POST)
	String loginUser(@RequestParam("name") String name) throws Exception// BindingResult result
	{
		if(!anonManager.hasUser(name))
		{
			anonManager.updateUser(new AnonUser(name));
			return "success";	
		}
		else
			return "failure";
	}
	
	//not a secure way of doing this, plus everything chat related should be put into various controllers
	//one for AnonUsers, one for CPPUsers (or w/e we call them), etc
	//possibly more depending on security and hierarchy
	@RequestMapping(value = "/chat/{name}", method = RequestMethod.GET)
	ModelAndView redirectToChat(@PathVariable("name") String name)
	{
		ModelAndView mav = new ModelAndView("chat"); 
		mav.addObject("user", anonManager.getUser(name));
		return mav;
	}
	
}

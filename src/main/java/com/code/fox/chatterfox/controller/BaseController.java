package com.code.fox.chatterfox.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "/login/anon/", method = RequestMethod.POST)
	String loginUser(@RequestParam("name") String name) throws Exception
	{
		if(!anonManager.hasUser(name))
		{
			anonManager.updateUser(new AnonUser(name));
			System.out.println("added " + name);
			return "success";	
		}
		else
			return "failure";
	}
	
	@RequestMapping(value = "/login/anon/{name}", method = RequestMethod.DELETE)
	void logoutUser(@PathVariable("name") String name) throws Exception
	{
		anonManager.deleteUser(name);
		System.out.println("deleted " + name);
	}
	
	@RequestMapping(value = "/chat/{name}", method = RequestMethod.GET)
	ModelAndView redirectToChat(@PathVariable("name") String name) throws Exception
	{
		if(anonManager.getUser(name) == null)
		{
			throw new IllegalArgumentException("No such user: " + name);
		}
		
		ModelAndView mav = new ModelAndView("chat"); 
		mav.addObject("user", anonManager.getUser(name));
		return mav;
	}
	
}

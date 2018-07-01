package com.be.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.be.services.UserServiceImpl;
import com.be.utilities.AppLogger;
/** 
 * @author chenjigaram Naveen
 *
 */
@RestController
@RequestMapping("account")
public class AccountController {

	

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/getRoleNames", method = RequestMethod.POST)
	public List<String> getRoles(@RequestBody String  userName) {

		List<String> roleNames =new ArrayList<String>();
		
		roleNames.add(userService.find(userName).getRole().getRoleName());
		
		
		return roleNames;
	}

	// this is the login api/service
	@CrossOrigin
	@RequestMapping("/login")
	public Principal user(Principal principal) {

		AppLogger.logError("AccountController","user","user logged "+principal);
		return principal;
	}
	
	
	
	
	
}

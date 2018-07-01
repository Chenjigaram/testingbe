package com.be.controller;



/** 
 * @author chenjigaram Naveen
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.be.beans.Message;
import com.be.entities.Role;
import com.be.entities.User;
import com.be.exceptions.CustomErrorType;
import com.be.services.RoleServiceImpl;
import com.be.services.UserServiceImpl;
import com.be.utilities.AppLogger;
@RestController
@RequestMapping("signup")
public class SignUpController {
	
	@Autowired
	private RoleServiceImpl roleService;
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	
	@RequestMapping(value="/allRoles",method=RequestMethod.GET)
	public List<Role> getAllRoles(){
		
		return roleService.getAllRoles();
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public Message register(@RequestBody User user) {
		Message message =null;
		try {
			message = new Message();
			if(userServiceImpl.find(user.getUserId())!=null || userServiceImpl.find(user.getUserName())!=null) {
				
				throw new CustomErrorType("User Already Exists with EMP Id");
			}
		user.setAccountStatus("InActive");
		userServiceImpl.save(user);
		message.setStatus(true);
		message.setMessage("Registration Completed");
		AppLogger.loginfo("SignUpController", "register",user.toString());
		}catch(Exception | CustomErrorType e) {
			AppLogger.logError("SignUpController", "register", e.getLocalizedMessage());
			message.setStatus(false);
			message.setMessage(e.getMessage());
		}
		return message;
		
	}
	
	@RequestMapping(value="/getUser",method=RequestMethod.POST)
	public User getUser(@RequestBody Long userId) {
		User user = null;
		try {
			user= userServiceImpl.find(userId);
		}catch(Exception e) {
			AppLogger.logError("SignUpController", "getUser for empID : "+userId, e.getLocalizedMessage());
			
		}
		return user;
	
	}
	
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public Message updateUser(@RequestBody User user) {
		
		Message message =null;
		try {
			message = new Message();
		user.setAccountStatus("InActive");
		userServiceImpl.save(user);
		message.setStatus(true);
		message.setMessage("Update Completed");
		AppLogger.loginfo("SignUpController", "updateUser",user.toString());
		}catch(Exception e) {
			AppLogger.logError("SignUpController", "register", e.getLocalizedMessage());
			message.setStatus(false);
			message.setMessage(e.getLocalizedMessage());
		}
		return message;
		
	}
	
	
	
}

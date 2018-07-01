package com.be.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.be.DAO.UserRepository;
import com.be.beans.Message;
import com.be.entities.User;
import com.be.utilities.AppLogger;


/** 
 * @author chenjigaram Naveen
 *
 */
@RestController
@RequestMapping("accessRequest")
public class AccessController {

	
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/getaccessRequests", method = RequestMethod.GET)
	public List<User> accessRequest() {
		
	List<User> users =null;
			try {
			 
				
				users=	userRepository.findByAccountStatus("InActive");
			}catch(Exception e) {
				
				AppLogger.logError("AccessController", "accessRequest", e.getLocalizedMessage());
			}
		return users;
	}
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<User> getAllActiveUsers() {
		
	List<User> users =null;
			try {
			 
				
				users=	userRepository.findByAccountStatus("Active");
			}catch(Exception e) {
				
				AppLogger.logError("AccessController", "getAllActiveUsers", e.getLocalizedMessage());
			}
		return users;
	}

	
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public Message updateUser(@RequestBody User user) {
		Message message =new Message();
		try {
		userRepository.setAccountStatusforEmpId(user.getUserId(), "Active");
		message.setStatus(true);
		message.setMessage("User updated Sucessfully");
		}catch(Exception e) {
			message.setStatus(false);
			message.setMessage(e.getLocalizedMessage());
			AppLogger.logError("AccessController", "updateUser", e.getLocalizedMessage());
		}
		return message;
		
	}
	
	
	@RequestMapping(value="/rejectUser",method=RequestMethod.POST)
	public Message rejectUser(@RequestBody User user) {
		
		Message message =new Message();
		try {
		userRepository.setAccountStatusforEmpId(user.getUserId(), "Rejected");
		message.setStatus(true);
		message.setMessage("User updated Sucessfully");
		}catch(Exception e) {
			message.setStatus(false);
			message.setMessage(e.getLocalizedMessage());
			AppLogger.logError("AccessController", "rejectUser", e.getLocalizedMessage());
		}
		return message;
		
	}
	
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	public Message deleteUser(@RequestBody User user) {
		
		Message message =new Message();
		try {
		userRepository.delete(user);
		message.setStatus(true);
		message.setMessage("User deleted Sucessfully");
		}catch(Exception e) {
			message.setStatus(false);
			message.setMessage(e.getLocalizedMessage());
			AppLogger.logError("AccessController", "deleteUser", e.getLocalizedMessage());
		}
		return message;
		
	}
	
}

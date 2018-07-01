package com.be.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.DAO.UserRepository;
import com.be.config.EncryptPasswordEncoder;
import com.be.entities.User;
/** 
 * @author Chenjigaram Naveen
 *
 */
@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EncryptPasswordEncoder encoder;
	

	public User save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	

	public User find(String userName) {
		return userRepository.findByUserName(userName);
	}

	public User find(Long userId) {
		return userRepository.findByUserId(userId);
	}
	
	
	
	
	
}

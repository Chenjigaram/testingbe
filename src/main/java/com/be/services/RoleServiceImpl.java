package com.be.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.DAO.RoleRepository;
import com.be.entities.Role;

/** 
 * @author Chenjigaram Naveen
 *
 */
@Service
public class RoleServiceImpl {

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getAllRoles(){
		
		return (List<Role>) roleRepository.findAll();
	}
	
}

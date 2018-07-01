package com.be.DAO;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.be.entities.Role;

/**
 * Created by Chenjigaram Naveen
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role findByRoleName(String roleName);
}

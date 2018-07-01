package com.be.DAO;




import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.be.entities.User;

/**
 * Created by Chenjigaram Naveen
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
   User findByUserName(String userName);
   User findByUserId(Long userId);
   @Transactional
   @Modifying
   @Query("UPDATE User c SET c.accountStatus = :accountstatus WHERE c.userId = :userid")
   void setAccountStatusforEmpId(@Param("userid") Long userId,@Param("accountstatus") String accountStatus);
   @Query("select distinct c from User c where c.accountStatus = :accountstatus")
   List<User> findByAccountStatus(@Param("accountstatus") String accountStatus);
}

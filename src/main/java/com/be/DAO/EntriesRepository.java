package com.be.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.be.entities.Entries;



public interface EntriesRepository extends CrudRepository<Entries, Long> {

	
	
	@Query("select distinct l from Entries l join fetch l.user u  where u.userName = :username")
	   List<Entries> findByUser_userName(@Param("username") String username );
	
	@Query("select distinct l from Entries l join fetch l.user u join l.match m"
			+ " where u.userName = :username and m.matchId = :matchid")
	   List<Entries> findByUser_userNameAndMatch_matchId(@Param("username") String username ,
			   @Param("matchid") Long matchId);
	
	
	@Query("select distinct l from Entries l join fetch l.match m  where m.matchId = :matchid")
	   List<Entries> findByMatch_matchId(@Param("matchid") Long matchId );
	
}

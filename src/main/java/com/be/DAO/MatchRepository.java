package com.be.DAO;

import org.springframework.data.repository.CrudRepository;

import com.be.entities.Match;


public interface MatchRepository extends CrudRepository<Match, Long> {

	Match findByMatchId(Long matchId);
	
	
}

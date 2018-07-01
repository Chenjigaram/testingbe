package com.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.be.DAO.MatchRepository;
import com.be.beans.Message;
import com.be.entities.Match;
import com.be.entities.Role;
import com.be.utilities.AppLogger;

@RestController
@RequestMapping("match")
public class MatchController {
	
	@Autowired
	private MatchRepository matchRepository;
	
	
	@RequestMapping(value="/addMatch",method=RequestMethod.POST)
	public Message saveMatch(@RequestBody Match match) {
		
		Message message =new Message();
		try {
			
			matchRepository.save(match);
		message.setStatus(true);
		message.setMessage("Match  added Sucessfully");
		}catch(Exception e) {
			message.setStatus(false);
			message.setMessage(e.getLocalizedMessage());
			AppLogger.logError("MatchController", "saveMatch", e.getLocalizedMessage());
		}
		return message;
		
	}
	
	
	@RequestMapping(value="/updateMatch",method=RequestMethod.POST)
	public Message updateMatch(@RequestBody Match match) {
		
		Message message =new Message();
		try {
			
			matchRepository.save(match);
		message.setStatus(true);
		message.setMessage("Match  updated Sucessfully");
		}catch(Exception e) {
			message.setStatus(false);
			message.setMessage(e.getLocalizedMessage());
			AppLogger.logError("MatchController", "updateMatch", e.getLocalizedMessage());
		}
		return message;
		
	}
	
	
	@RequestMapping(value="/deleteMatch",method=RequestMethod.POST)
	public Message deleteMatch(@RequestBody Match match) {
		
		Message message =new Message();
		try {
			
			matchRepository.delete(match);
		message.setStatus(true);
		message.setMessage("Match  deleted Sucessfully");
		}catch(Exception e) {
			message.setStatus(false);
			message.setMessage(e.getLocalizedMessage());
			AppLogger.logError("MatchController", "deleteMatch", e.getLocalizedMessage());
		}
		return message;
		
	}
	
	
	@RequestMapping(value="/allMatches",method=RequestMethod.GET)
	public List<Match> getAllMatches(){
		
		return (List<Match>) matchRepository.findAll();
	}
	
	@RequestMapping(value="/findMatch/{matchId}",method=RequestMethod.GET)
	public Match getMatch(@PathVariable(value="matchId") Long matchId){
		
		return matchRepository.findByMatchId(matchId);
	}
	
	
}

package com.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.be.DAO.EntriesRepository;
import com.be.beans.Message;
import com.be.entities.Entries;
import com.be.utilities.AppLogger;

@RestController
@RequestMapping("entries")
public class EntriesController {
	
	@Autowired
	private EntriesRepository entriesRepo;
	
	
	@RequestMapping(value="/addEntry",method=RequestMethod.POST)
	public Message addEntry(@RequestBody Entries entries) {
		
		Message message =new Message();
		try {
			
			entriesRepo.save(entries);
		message.setStatus(true);
		message.setMessage("Entry  added Sucessfully");
		}catch(Exception e) {
			e.printStackTrace();
			message.setStatus(false);
			message.setMessage(e.getLocalizedMessage());
			AppLogger.logError("MatchController", "addEntry", e.getLocalizedMessage());
		}
		return message;
		
	}
	
	@RequestMapping(value="/updateEntry",method=RequestMethod.POST)
	public Message updateEntry(@RequestBody Entries entries) {
		
		Message message =new Message();
		try {
			
			entriesRepo.save(entries);
		message.setStatus(true);
		message.setMessage("Entry  updated Sucessfully");
		}catch(Exception e) {
			message.setStatus(false);
			message.setMessage(e.getLocalizedMessage());
			AppLogger.logError("MatchController", "updateEntry", e.getLocalizedMessage());
		}
		return message;
		
	}
	
	@RequestMapping(value="/deleteEntry",method=RequestMethod.POST)
	public Message deleteEntry(@RequestBody Entries entries) {
		
		Message message =new Message();
		try {
			
			entriesRepo.delete(entries);
		message.setStatus(true);
		message.setMessage("Entry  deleted Sucessfully");
		}catch(Exception e) {
			message.setStatus(false);
			message.setMessage(e.getLocalizedMessage());
			AppLogger.logError("MatchController", "deleteEntry", e.getLocalizedMessage());
		}
		return message;
		
	}
	
	@RequestMapping(value="/userEntries/{userName}",method=RequestMethod.GET)
	public List<Entries> userEntries(@PathVariable(value="userName") String userName){
		
		return entriesRepo.findByUser_userName(userName);
	}
	
	@RequestMapping(value="/matchEntries/{matchId}",method=RequestMethod.GET)
	public List<Entries> matchEntries(@PathVariable(value="matchId") Long matchId){
		
		return entriesRepo.findByMatch_matchId(matchId);
	}
	
	@RequestMapping(value="/user/{userName}/match/{matchId}",method=RequestMethod.GET)
	public List<Entries> userANDmatchEntries(@PathVariable(value="matchId") Long matchId ,@PathVariable(value="userName") String userName){
		
		return entriesRepo.findByUser_userNameAndMatch_matchId(userName, matchId);
	}
	
	
}

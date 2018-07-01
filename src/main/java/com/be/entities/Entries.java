package com.be.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="match_entry")
public class Entries {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="entry_id")
	private Long entryId;
	
	@ManyToOne
	@JoinColumn(name="match_id")
	private Match match;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="match_rate")
	private Long matchRate;
	@Column(name="entry_type")
	private String entryType;
	@Column(name="bet_amount")
	private Long betAmount;
	@Column(name="match_amount")
	private Long matchAmount;
	@Column(name="bet_team")
	private String betTeam;
	
	public String getBetTeam() {
		return betTeam;
	}
	public void setBetTeam(String betTeam) {
		this.betTeam = betTeam;
	}
	public Long getBetAmount() {
		return betAmount;
	}
	public void setBetAmount(Long betAmount) {
		this.betAmount = betAmount;
	}
	public Long getMatchAmount() {
		return matchAmount;
	}
	public void setMatchAmount(Long matchAmount) {
		this.matchAmount = matchAmount;
	}
	public Long getEntryId() {
		return entryId;
	}
	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getMatchRate() {
		return matchRate;
	}
	public void setMatchRate(Long matchRate) {
		this.matchRate = matchRate;
	}
	public String getEntryType() {
		return entryType;
	}
	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}
	
	
	
}

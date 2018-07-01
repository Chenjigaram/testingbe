package com.be.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="match_table")
public class Match {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="match_id")
	private Long matchId;
	@Column(name="team_a")
	private String teamA;
	@Column(name="team_b")
	private String teamB;
	@Column(name="match_date")
	@Temporal(TemporalType.DATE)
	private Calendar matchDate;
	@Column(name="description")
	private String description;
	@Column(name="match_winner")
	private String matchWinner;
	public Long getMatchId() {
		return matchId;
	}
	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}
	public String getTeamA() {
		return teamA;
	}
	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}
	public String getTeamB() {
		return teamB;
	}
	public void setTeamB(String teamB) {
		this.teamB = teamB;
	}
	public Calendar getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(Calendar matchDate) {
		this.matchDate = matchDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMatchWinner() {
		return matchWinner;
	}
	public void setMatchWinner(String matchWinner) {
		this.matchWinner = matchWinner;
	}
	
	
}

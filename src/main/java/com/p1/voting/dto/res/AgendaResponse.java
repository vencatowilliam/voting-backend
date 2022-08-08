package com.p1.voting.dto.res;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.p1.voting.model.Agenda;
import com.p1.voting.model.Vote;

public class AgendaResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4759256514895625216L;

	private Long id;

	private String agendaTitle;

	private String agendaDescription;

	private Integer expirationTime;

	private LocalDateTime expirationDate;

	private List<Vote> votes = new ArrayList<>();

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public AgendaResponse() {
	}

	public AgendaResponse(Agenda agenda) {
		this.id = agenda.getId();
		this.agendaTitle = agenda.getAgendaTitle();
		this.agendaDescription = agenda.getAgendaDescription();
		this.expirationTime = agenda.getExpirationTime();
		this.expirationDate = agenda.getExpirationDate();
		this.votes = agenda.getVotes();
		this.createdAt = agenda.getCreatedAt();
		this.updatedAt = agenda.getUpdatedAt();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgendaTitle() {
		return agendaTitle;
	}

	public void setAgendaTitle(String agendaTitle) {
		this.agendaTitle = agendaTitle;
	}

	public String getAgendaDescription() {
		return agendaDescription;
	}

	public void setAgendaDescription(String agendaDescription) {
		this.agendaDescription = agendaDescription;
	}

	public Integer getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Integer expirationTime) {
		this.expirationTime = expirationTime;
	}

	public LocalDateTime expirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void openVotation(Integer expirationTime) {
		this.expirationDate = (LocalDateTime.now()).plusMinutes(expirationTime);
	}

	public Boolean votationIsOpen() {
		return this.expirationDate.isBefore(LocalDateTime.now());
	}
}

package com.p1.voting.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.p1.voting.dto.req.AgendaRequest;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Agenda implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7435784370833481268L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(length = 100)
	private String agendaTitle;

	@NotBlank
	@Column(length = 500)
	private String agendaDescription;

	@Column
	private Integer expirationTime;

	@Column
	@JsonIgnore
	private LocalDateTime expirationDate;

	@OneToMany(mappedBy = "agenda")
	private List<Vote> votes = new ArrayList<>();

	@CreatedDate
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	public Agenda () {}

	public Agenda(AgendaRequest obj) {
		super();
		this.agendaTitle = obj.getAgendaTitle();
		this.agendaDescription = obj.getAgendaDescription();
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

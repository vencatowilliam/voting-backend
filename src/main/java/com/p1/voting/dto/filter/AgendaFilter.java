package com.p1.voting.dto.filter;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AgendaFilter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4991153362242177216L;

	private String agendaTitle;

	private String agendaDescription;

	private Integer expirationTime;

	private LocalDateTime expirationDate;

	private String any;

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

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getAny() {
		return any;
	}

	public void setAny(String any) {
		this.any = any;
	}
}

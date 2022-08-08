package com.p1.voting.dto.req;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.p1.voting.model.Agenda;

public class AgendaRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2401984880676847613L;

	@NotBlank
	private String agendaTitle;

	@NotBlank
	private String agendaDescription;

	private Integer expirationTime;

	public Agenda toModel(Agenda agenda) {
		agenda.setAgendaTitle(agendaTitle);
		agenda.setAgendaDescription(agendaDescription);
		agenda.setExpirationTime(expirationTime);

		return agenda;
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
}

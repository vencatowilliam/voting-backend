package com.p1.voting.dto.req;

import java.io.Serializable;

public class VoteRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6592477913739849447L;

	private Long memberId;

	private Long agendaId;

	private Boolean vote;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(Long agendaId) {
		this.agendaId = agendaId;
	}

	public Boolean getVote() {
		return vote;
	}

	public void setVote(Boolean vote) {
		this.vote = vote;
	}
}

package com.p1.voting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p1.voting.dto.req.VoteRequest;
import com.p1.voting.model.Vote;
import com.p1.voting.repository.AgendaRepository;
import com.p1.voting.repository.VoteRepository;

@Service
public class VoteService {
	@Autowired
	private VoteRepository voteRepository;
	@Autowired
	private AgendaRepository agendaRepository;

	public List<Vote> index() {
		return voteRepository.findAll();
	}

	private Vote save(Vote obj) {
		return this.voteRepository.save(obj);
	}

	public Long store(VoteRequest dto) {
		Vote vote = this.toModel(dto);
		vote = this.save(vote);
		return vote.getId();
	}

	public Vote toModel(VoteRequest obj) {
		Vote newObj = new Vote();

		newObj.setMemberId(obj.getMemberId());
		newObj.setAgenda(this.agendaRepository.findById(obj.getAgendaId()).get());
		newObj.setVote(obj.getVote());

		return newObj;
	}
}

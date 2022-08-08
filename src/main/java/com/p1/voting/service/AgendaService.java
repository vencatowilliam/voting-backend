package com.p1.voting.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p1.voting.dto.req.AgendaRequest;
import com.p1.voting.dto.res.AgendaResponse;
import com.p1.voting.model.Agenda;
import com.p1.voting.repository.AgendaRepository;

@Service
public class AgendaService {
	@Autowired
	private AgendaRepository agendaRepository;

	public List<Agenda> index() {
		return agendaRepository.findAll();
	}

	private Agenda save(Agenda obj) {
		return this.agendaRepository.save(obj);
	}

	public Optional<AgendaResponse> show(Long id) {
		return this.agendaRepository.findById(id).map(AgendaResponse::new);
	}

	public Long store(AgendaRequest dto) {
		Agenda agenda = dto.toModel(new Agenda());
		agenda = this.save(agenda);
		return agenda.getId();
	}

	public void update(Long id, @Valid AgendaRequest dto) {
		Agenda agenda = dto.toModel(this.agendaRepository.findById(id).get());
		agenda = this.save(agenda);
	}

	public void destroy(Long id) {
		this.agendaRepository.deleteById(id);
	}
}

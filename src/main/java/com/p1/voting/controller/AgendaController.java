package com.p1.voting.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.p1.voting.dto.req.AgendaRequest;
import com.p1.voting.dto.res.AgendaResponse;
import com.p1.voting.model.Agenda;
import com.p1.voting.service.AgendaService;

@RestController
@RequestMapping("/api/pautas")
public class AgendaController {

	@Autowired
	private AgendaService agendaService;

	@GetMapping
	public List<Agenda> index() {
		return this.agendaService.index();
	}

	@GetMapping("/{id}")
	public Optional<AgendaResponse> show(@PathVariable Long id) {
		return this.agendaService.show(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Long store(@Valid @RequestBody AgendaRequest dto) {
		return this.agendaService.store(dto);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @Valid @RequestBody AgendaRequest dto) {
		this.agendaService.update(id, dto);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void destroy(@PathVariable Long id) {
		this.agendaService.destroy(id);
	}
}
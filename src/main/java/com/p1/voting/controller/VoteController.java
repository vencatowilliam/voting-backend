package com.p1.voting.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.p1.voting.dto.req.VoteRequest;
import com.p1.voting.model.Vote;
import com.p1.voting.service.VoteService;

@RestController
@RequestMapping("/api/votos")
public class VoteController {

	@Autowired
	private VoteService voteService;

	@GetMapping
	public List<Vote> index() {
		return this.voteService.index();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Long store(@Valid @RequestBody VoteRequest dto) {
		return this.voteService.store(dto);
	}
}
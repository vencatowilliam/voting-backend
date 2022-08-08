package com.p1.voting.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.p1.voting.model.Member;
import com.p1.voting.service.MemberService;

@RestController
@RequestMapping("/api/associados")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping
	public ResponseEntity<List<Member>> index() {
		List<Member> list = memberService.index();
		return ResponseEntity.ok().body(list);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Long store(@Valid @RequestBody Member dto) {
		return this.memberService.store(dto);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void destroy(@PathVariable Long id) {
		this.memberService.destroy(id);
	}
}
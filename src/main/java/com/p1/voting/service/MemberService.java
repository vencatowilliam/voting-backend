package com.p1.voting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p1.voting.model.Member;
import com.p1.voting.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	public List<Member> index() {
		return memberRepository.findAll();
	}

	private Member save(Member obj) {
		return this.memberRepository.save(obj);
	}

	public Long store(Member obj) {
		Member member = this.save(obj);
		return member.getId();
	}

	public void destroy(Long id) {
		this.memberRepository.deleteById(id);
	}
}

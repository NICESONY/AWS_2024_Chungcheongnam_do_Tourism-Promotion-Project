package com.example.securityexam;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public void create(Member member) {
		
		member.setEnabled(true);
		member.setRole("ROLE_USER"); //ROLE_ADMIN, ROLE_MANAGER, ROLE_PAID...
		member.setMdate(LocalDateTime.now());
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		memberRepository.save(member);
	}
}

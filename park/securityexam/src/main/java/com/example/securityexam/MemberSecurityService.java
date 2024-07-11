package com.example.securityexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class MemberSecurityService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Member> tmember = memberRepository.findByusername(username);
		if (tmember.isEmpty()) {
			throw new UsernameNotFoundException("You need to Sign up first...");
		}
		
		Member member = tmember.get();
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if ("ROLE_USER".equals(member.getRole())) {
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		} else if ("ROLE_MANAGER".equals(member.getRole())) {
			authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
		} else {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		
		return new User(member.getUsername(), member.getPassword(), authorities);
	}

}

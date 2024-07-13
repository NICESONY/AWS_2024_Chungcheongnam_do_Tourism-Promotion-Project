package com.example.extraclass.Member;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements UserDetailsService {

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

public void create(Member member) {

member.setEnabled(true);
member.setRole("ROLE_USER"); //ROLE_ADMIN, ROLE_MANAGER, ROLE_PAID...
member.setDate(LocalDateTime.now());
BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
member.setPassword(passwordEncoder.encode(member.getPassword()));
memberRepository.save(member);

}

public Member authen() {
	
	 Authentication authentication =
	 SecurityContextHolder.getContext().getAuthentication(); UserDetails
	 userDetails = (UserDetails) authentication.getPrincipal(); String username=
	 userDetails.getUsername();
	  
	 Optional<Member> oc = memberRepository.findByusername(username);
	 
	 return oc.get();
}


}
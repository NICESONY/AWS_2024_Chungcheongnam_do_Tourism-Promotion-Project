package com.mysite.sbb.user;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

	public SiteUser create(String username, String email, String password) {
		SiteUser user = new SiteUser();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		
		this.userRepository.save(user);
		return user;
	}
	public SiteUser authen() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();
		
		Optional<SiteUser> oc = userRepository.findByusername(username);
		return oc.get();
	}
}

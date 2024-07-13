package com.example.extraclass.Board;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.extraclass.Member.MemberRepository;
import com.example.extraclass.Member.MemberService;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private MemberService customerService;
	
	/*
	 * public void create(Board board, Principal principal) {
	 * 
	 * Optional<Customer> oc =
	 * customerRepository.findByusername(principal.getName());
	 * 
	 * board.setCustomer(oc.get()); board.setDate(LocalDateTime.now());
	 * 
	 * boardRepository.save(board); }
	 */
	
	public void create(Board board) {
		
		/*
		 * Authentication authentication =
		 * SecurityContextHolder.getContext().getAuthentication(); UserDetails
		 * userDetails = (UserDetails) authentication.getPrincipal(); String username=
		 * userDetails.getUsername();
		 * 
		 * Optional<Customer> oc = customerRepository.findByusername(username);
		 * 
		 * board.setCustomer(oc.get());
		 */
		
		board.setDate(LocalDateTime.now());
		
		boardRepository.save(board);
	}
}

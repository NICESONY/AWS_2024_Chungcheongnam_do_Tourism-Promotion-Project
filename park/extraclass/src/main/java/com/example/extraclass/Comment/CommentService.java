package com.example.extraclass.Comment;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.extraclass.Board.Board;
import com.example.extraclass.Member.MemberService;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private MemberService memberService;
	
	/*
	 * public void create(Board board, Principal principal) {
	 * 
	 * Optional<Customer> oc =
	 * customerRepository.findByusername(principal.getName());
	 * 
	 * board.setCustomer(oc.get()); board.setDate(LocalDateTime.now());
	 * 
	 * commentRepository.save(board); }
	 */
	
	public void create(Comment comment) {
		
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
		
		comment.setAuthor(memberService.authen());
		comment.setDate(LocalDateTime.now());
		
		commentRepository.save(comment);
	}
}

package com.example.extraclass.Comment;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/comment")
@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/create")
	public String create() {
		return "comment/create";
	}

	/*
	 * @PostMapping("/create") public String create(Board board, Principal
	 * principal) {
	 * 
	 * boardService.create(board, principal); return "redirect:/"; }
	 */
	
	@PostMapping("/create")
	public String create(Comment board) {
		
		commentService.create(board);
		return "redirect:/";
	}
	
}

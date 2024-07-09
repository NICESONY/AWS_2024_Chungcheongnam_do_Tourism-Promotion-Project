package com.example.adminexam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
	@GetMapping("/board")
	public String board() {
		return "board";
	}
	
	@PostMapping("/board")
	public String board(@ModelAttribute Board board
			) {
		System.out.println(board.getTitle());
		System.out.println(board.getContent());
		return "index";
	}
	@GetMapping("/boardlist")
	public String boardlist() {
		return "boardlist";
	}
	@GetMapping("/boarddetail/{no}")
	public String boarddetail(@PathVariable("no") String no) {
		System.out.println("넘어온 번호는 "+ no);
		return "boardlist";
	}
}
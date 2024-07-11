package com.example.advsecurityexam.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	@GetMapping("/create")
	public String create() {
		return "board/create";
	}
	@PostMapping("/create")
	public String create(Board board) {
		boardService.create(board);
		return "redirect:/board/create";
	}
}

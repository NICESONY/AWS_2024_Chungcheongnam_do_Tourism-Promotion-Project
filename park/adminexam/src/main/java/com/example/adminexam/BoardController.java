package com.example.adminexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/readlist")
	public String readlist(Model model) {
		model.addAttribute("boards", boardService.readlist());
		return "readlist";
	}
	@GetMapping("/create")
	public String create() {
		return "create";
	}
	@PostMapping("/create")
	public String create(@ModelAttribute Board board) {
		boardService.create(board);
		return "redirect:/board/readlist";
	}
	@GetMapping("/boarddetail/{no}")
	public String boarddetail(@PathVariable("no") String no) {
		System.out.println("넘어온 번호는 "+ no);
		return "boardlist";
	}
}
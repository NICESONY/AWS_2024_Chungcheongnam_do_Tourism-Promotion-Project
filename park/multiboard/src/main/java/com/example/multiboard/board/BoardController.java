package com.example.multiboard.board;

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
	
	@GetMapping("/create/{type}")
	public String create(Model model, @PathVariable ("type") Integer type) {
		model.addAttribute("type", type);
		return "board/create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute Board board) {
		boardService.create(board);
		return "board/readlist";
	}
	
	@GetMapping("/readlist/{type}")
	public String readlist(Model model, @PathVariable ("type") Integer type) {
		model.addAttribute("type", type);
		model.addAttribute("boards", boardService.readlist(type));
		return "board/readlist";
	}
	
	@GetMapping("/readdetail/{bid}")
	public String readdetail(Model model, @PathVariable ("bid") Integer bid) {
		model.addAttribute("board", boardService.readdetail(bid));
		return "board/readdetail";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable ("id") Integer id) {
		boardService.delete(id);
		return "redirect:/board/readlist";
	}
	
}

package com.mysite.sbb;

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
	
	@PostMapping ("/create") 
	public String create(@ModelAttribute Board board ) {
		
		return "redirect:/board/readlist";
	}
	
	@GetMapping("/readdetail/{id}")
	public String readdetail(Model model, @PathVariable ("id") Integer id) {
		
		model.addAttribute("board", boardService.readdetail(id));
		
		return "readdetail";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable ("id") Integer id) {
		
		boardService.readdetail(id);
		return "redirect:/board/readlist";
	}
	
	@GetMapping("/update/{id}")
	public String update(Model model,@PathVariable("id") Integer id) {
		model.addAttribute("board", boardService.readdetail(id));
		return "update";
	}
	
	@PostMapping ("/update") 
	public String update(@ModelAttribute Board board ) {
		
		
		return "redirect:/board/readlist";
	}
}

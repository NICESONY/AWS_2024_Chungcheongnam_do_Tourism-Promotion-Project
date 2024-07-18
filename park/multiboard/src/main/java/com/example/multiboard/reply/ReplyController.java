package com.example.multiboard.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reply")
@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/create/{bid}")
	public String create(Reply reply, @PathVariable("bid")Integer bid) {

		replyService.create(reply, bid);
		return "redirect:/board/readdetail/"+bid;
	}
}

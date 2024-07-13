package com.mysite.homework7.yoojinwon.Comment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.homework7.yoojinwon.Notice.NoticeService1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CommentController1 {
	
	private final CommentService1 cs;
	private final NoticeService1 ns;
	
	@PostMapping("/comment/create/{id}")
	public String commentCreate(@RequestParam("content") String content, @PathVariable("id") Integer id) {
		cs.create(content ,id);
		
		return "redirect:/notice/detail/"+id;
	}
	
	@GetMapping("/comment/delete/{nid}/{cid}")
	public String commentDelete(@PathVariable("nid") Integer nid, @PathVariable("cid") Integer cid) {
		
		cs.delete(cid);
		return "redirect:/notice/detail/"+nid;
	}
	
	@GetMapping("/comment/update/{id}")
	public String commentFix(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("comment",cs.getComment(id));
		return "yoojinwon/commentfix1";
	}
	@PostMapping("/comment/update/{id}")
	public String commentUpdate(@RequestParam("content") String s,@PathVariable("id") Integer id) {
		Comment1 c = cs.getComment(id);
		c.setContent(s);
		cs.update(c);
		return "redirect:/notice/detail/" + c.getNotice().getId();
	}
}

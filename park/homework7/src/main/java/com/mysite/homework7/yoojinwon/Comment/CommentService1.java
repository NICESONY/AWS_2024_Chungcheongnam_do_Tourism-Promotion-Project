package com.mysite.homework7.yoojinwon.Comment;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.homework7.yoojinwon.Notice.NoticeService1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService1 {
	
	private final CommentRepository1 cr;
	private final NoticeService1 ns;
	
	public void create(String content, Integer id) {
		Comment1 comm = new Comment1();
		comm.setContent(content);
		comm.setDate(LocalDateTime.now());
		comm.setNotice(ns.getnoticeByid(id));
		
		cr.save(comm);
	}
	public void delete(Integer id) {
		cr.deleteById(id);
	}
	public Comment1 getComment(Integer id) {
		Optional<Comment1> op = cr.findById(id);
		return op.get();
	}
	public void update(Comment1 c) {
		cr.save(c);
	}
}

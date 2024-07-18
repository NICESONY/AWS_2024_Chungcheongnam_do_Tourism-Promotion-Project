package com.example.multiboard.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.multiboard.board.Board;
import com.example.multiboard.board.BoardService;

@Service
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	
	@Autowired
	private BoardService boardService;
	public void create(Reply reply, Integer bid) {
		
		Board board = boardService.readdetail(bid);
		
		reply.setBoard(board);
		replyRepository.save(reply);
	}
}

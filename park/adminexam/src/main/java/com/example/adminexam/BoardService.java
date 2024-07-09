package com.example.adminexam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	public void create(Board board) {
//	        Board board = new Board();
//	        board.setTitle(title);
//	        board.setContent(content);
	        board.setDate(LocalDateTime.now());
	        this.boardRepository.save(board);
	    }
	public List <Board>readlist(){
		return boardRepository.findAll();	
	}
	public Board readdetail(Integer id) {
		
		Optional<Board> o = boardRepository.findById(id);
		
		return o.get();
	}
}

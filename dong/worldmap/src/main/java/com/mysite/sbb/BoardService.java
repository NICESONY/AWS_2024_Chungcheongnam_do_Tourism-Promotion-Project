package com.mysite.sbb;

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
		
//		Board board = new Board();
//		
//		board.setTitle(title);
//		board.setContent(content);
		board.setData(LocalDateTime.now());
		
		boardRepository.save(board);
	}
	
	public List<Board> readlist() {
		return boardRepository.findAll();
		
	}
	
	public Board readdetail(Integer id) {
		Optional<Board> o = boardRepository.findById(id);
		
		return o.get();
	}
	
	public void delete(Integer id) {
		boardRepository.deleteById(id);	
	}
	
	public void Update(Board board) {
		boardRepository.save(board);
	}
	
	
	
}

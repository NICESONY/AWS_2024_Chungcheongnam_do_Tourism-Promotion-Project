package com.example.multiboard.board;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	public String create(Board board) {
		boardRepository.save(board);
		return "create";
	}

	public List<Board> readlist(Integer type) {
	//	return boardRepository.findAll();
	return boardRepository.findByType(type);
	}
	public Board readdetail(Integer id) {
		Optional<Board>ob = boardRepository.findById(id);
		return ob.get();
	}
	public void update(Board board) {
		boardRepository.save(board);
	}
	public void delete(Integer id) {
		boardRepository.deleteById(id);
	}
}

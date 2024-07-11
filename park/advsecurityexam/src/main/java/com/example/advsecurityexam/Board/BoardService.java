package com.example.advsecurityexam.Board;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.advsecurityexam.CustomerService;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private CustomerService customerService;
	
	public void create(Board board) {
		board.setCustomer(customerService.authen());
		board.setDate(LocalDateTime.now());
		
		boardRepository.save(board);
	}
	
}

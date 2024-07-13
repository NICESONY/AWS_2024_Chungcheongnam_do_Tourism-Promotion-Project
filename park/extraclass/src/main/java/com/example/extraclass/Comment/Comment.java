package com.example.extraclass.Comment;

import java.time.LocalDateTime;

import com.example.extraclass.Board.Board;
import com.example.extraclass.Member.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String content;
	@ManyToOne
	private Member author;	
	@ManyToOne
	private Board board;
	
	private LocalDateTime date;
}

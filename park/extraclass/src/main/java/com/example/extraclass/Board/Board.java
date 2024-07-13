package com.example.extraclass.Board;

import java.time.LocalDateTime;
import java.util.List;

import com.example.extraclass.Comment.Comment;
import com.example.extraclass.Member.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;
	private String content;	
	
	private String image;
	
	@ManyToOne
	private Member author;
	@OneToMany
	private List<Comment> commentList;
	private LocalDateTime date;
}

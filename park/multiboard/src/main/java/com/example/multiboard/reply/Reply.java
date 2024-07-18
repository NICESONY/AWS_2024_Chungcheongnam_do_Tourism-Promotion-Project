package com.example.multiboard.reply;

import java.time.LocalDateTime;

import com.example.multiboard.board.Board;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Reply {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(length = 200)
	    private String subject;

	    @Column(columnDefinition = "TEXT")
	    private String content;

	    private LocalDateTime createDate;
	    @ManyToOne
	    private Board board;
}

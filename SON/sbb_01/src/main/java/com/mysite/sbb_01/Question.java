package com.mysite.sbb_01;

import java.time.LocalDateTime;

import com.mysite.sbb.Column;
import com.mysite.sbb.GeneratedValue;
import com.mysite.sbb.Id;

import lombok.Data;

@Data
@Entity
public class Question {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
    

}
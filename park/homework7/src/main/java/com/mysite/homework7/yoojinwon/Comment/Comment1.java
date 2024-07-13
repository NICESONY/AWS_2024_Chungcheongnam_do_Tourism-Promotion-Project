package com.mysite.homework7.yoojinwon.Comment;

import java.time.LocalDateTime;

import com.mysite.homework7.yoojinwon.Notice.Notice1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Comment1 {

	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column
    private String content; 

    private LocalDateTime date; 

    @ManyToOne 
    private Notice1 notice; 
}

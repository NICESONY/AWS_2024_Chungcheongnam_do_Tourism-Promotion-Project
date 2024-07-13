package com.mysite.homework7.yoojinwon.Notice;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.homework7.yoojinwon.Comment.Comment1;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Notice1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id; 

    @Column(length = 200) 
    private String title; 

    @Column(columnDefinition = "TEXT") 
    private String content; 

    private String image1;
    
    private String image2;
    private String image3;
    
    private LocalDateTime date; 

    @OneToMany(mappedBy = "notice", cascade = CascadeType.REMOVE) 
    private List<Comment1> commentList;
}
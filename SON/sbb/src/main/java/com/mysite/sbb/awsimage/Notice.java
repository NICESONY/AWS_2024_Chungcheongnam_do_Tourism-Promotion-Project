package com.mysite.sbb.awsimage;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Notice {
	
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	
	
	private String title;
	
	
	private String content;
	
	
	private String image1;
	
	
	private LocalDateTime createDate; 
	
	
	
	

}

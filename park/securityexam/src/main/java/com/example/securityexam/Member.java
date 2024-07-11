package com.example.securityexam;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mid;
	
	@Column(unique = true)
	private String username; // for SpringSecurity Policy
	private String password; // for SpringSecurity Policy
	private boolean enabled; // for SpringSecurity Policy
	private String role; // for SpringSecurity Policy
	@Column(unique = true)
	private String memail;
	private LocalDateTime mdate;

}

package com.example.extraclass.Member;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Member {
//id username password email date
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(unique = true)
private String username; // for SpringSecurity Policy
private String password; // for SpringSecurity Policy
private boolean enabled; // for SpringSecurity Policy
private String role;           // for SpringSecurity Policy

@Column(unique = true)
private String email;
private LocalDateTime date;

}
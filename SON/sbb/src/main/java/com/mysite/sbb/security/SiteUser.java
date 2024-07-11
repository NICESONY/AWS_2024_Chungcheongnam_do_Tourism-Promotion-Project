package com.mysite.sbb.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;



@Data
@Entity
public class SiteUser {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(unique = true)
    private String username;

    
    private String password;

    
    @Column(unique = true)
    private String email;
}

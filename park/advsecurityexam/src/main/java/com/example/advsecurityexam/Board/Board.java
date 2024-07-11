package com.example.advsecurityexam.Board;


import java.time.LocalDateTime;

import com.example.advsecurityexam.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Board {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer cid;

private String title;
private String content;

@ManyToOne
Customer customer;

private LocalDateTime date;
}

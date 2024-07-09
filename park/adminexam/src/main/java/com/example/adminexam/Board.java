package com.example.adminexam;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Board {
	Integer id;
	String title;
	String content;
	Integer date;
	
	
}

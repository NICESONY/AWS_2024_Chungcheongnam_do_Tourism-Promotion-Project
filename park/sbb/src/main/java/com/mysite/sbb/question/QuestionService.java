package com.mysite.sbb.question;

import org.springframework.web.multipart.MultipartFile;

public interface QuestionService {
	public Question getQuestion(Integer id);
	public void create(Question question, MultipartFile file1);
	
}

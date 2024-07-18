package com.mysite.sbb.question;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface QuestionService {
	public Question getQuestion(Integer id);
	public void create(Question question, MultipartFile file1);
	public void delete(Integer id);
	public List<Question>readlist();
	public List<Question>findBySubjectLike(String kw);
}

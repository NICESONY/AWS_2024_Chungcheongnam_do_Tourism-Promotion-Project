package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.sbb.question.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject, String content);

}

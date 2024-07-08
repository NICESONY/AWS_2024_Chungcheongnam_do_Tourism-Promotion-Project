package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.sbb.answer.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer > {

}

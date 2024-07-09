package com.mysite.sbb.question;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository; 
	
	public Question getQuestion(Integer id) {  
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else { 
            throw new DataNotFoundException("question not found");
        }
    }
}

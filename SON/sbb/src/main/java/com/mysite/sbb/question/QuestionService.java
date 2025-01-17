package com.mysite.sbb.question;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.awsimage.S3service;

@Service
public class QuestionService {
	
	
	@Autowired
	private QuestionRepository questionRepository; 
	
	@Autowired
	private S3service s3service; 
	
	
	
	
	public Question getQuestion(Integer id) {  
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else { 
            throw new DataNotFoundException("question not found");
        }
        
    }
	
    public void create(Question question, MultipartFile file1) throws IOException {
        
    	UUID uuid = UUID.randomUUID();
    	String fileName1 = uuid + "_" + file1.getOriginalFilename();
    	
    	s3service.uploadFile(file1, fileName1);
    	question.setImage1(fileName1);
    	question.setCreateDate(LocalDateTime.now());

        this.questionRepository.save(question);
    }
    
    
    public void delete(Integer id) {
    	questionRepository.deleteById(id);
    	
    	
    }
    
    public void update(String subject, String content) {
        Question u = new Question();
        u.setSubject(subject);
        u.setContent(content);
        u.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(u);
    }
}

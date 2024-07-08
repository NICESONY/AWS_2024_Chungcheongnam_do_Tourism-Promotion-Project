package com.example._8;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void testJpa() {        
    	 assertEquals(2, this.questionRepository.count());
         Optional<Question> oq = this.questionRepository.findById(1);
         assertTrue(oq.isPresent());
         Question q = oq.get();
         this.questionRepository.delete(q);
         assertEquals(1, this.questionRepository.count());
    }
}
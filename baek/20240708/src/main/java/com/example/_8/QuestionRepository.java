package com.example._8;

public interface QuestionRepository {

	import org.springframework.data.jpa.repository.JpaRepository;

	public interface QuestionRepository extends JpaRepository<Question, Integer> {
	    Question findBySubject(String subject);
	}
	
}

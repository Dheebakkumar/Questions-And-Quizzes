package com.QuizMicroServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.QuizMicroServices.model.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {

	List<Question> findByCategory(String category);

	@Query(value ="SELECT * FROM quizandquestions.question q Where q.category =:category ORDER BY RAND () limit :count",nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, int count);
 
}

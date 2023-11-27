package com.QuizMicroServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizMicroServices.model.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long>{

}

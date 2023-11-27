package com.QuizMicroServices.service;

import java.util.List;

import com.QuizMicroServices.DTO.QuestionDto;

public interface QuestionService {

	public QuestionDto addQuestion(QuestionDto questionDto);
	public List<QuestionDto> getAllQuestions();
	public List<QuestionDto> getAllByCategory(String category);
	
}

package com.QuizMicroServices.service;

import java.util.List;

import com.QuizMicroServices.DTO.QuizDto;
import com.QuizMicroServices.DTO.QuizWrapperDto;
import com.QuizMicroServices.DTO.ResponseDto;

public interface QuizService {

	public QuizDto createQuiz(String category , int count ,QuizDto quizDto);
	
	public List<QuizWrapperDto> getQuizQuestions(long id);
	
	public String calculateResult(long id,List<ResponseDto> response);
}

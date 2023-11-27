package com.QuizMicroServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuizMicroServices.DTO.QuizDto;
import com.QuizMicroServices.DTO.QuizWrapperDto;
import com.QuizMicroServices.DTO.ResponseDto;
import com.QuizMicroServices.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizService service;
	
	@PostMapping("/add/category/{category}/count/{count}")
	public QuizDto createQuiz(@PathVariable String category ,@PathVariable int count ,@RequestBody QuizDto quizDto) {
		
		return service.createQuiz(category, count, quizDto);
	}

	@GetMapping("/get/{id}")
	public List<QuizWrapperDto> getQuizQuestions(@PathVariable long id){
		
		return service.getQuizQuestions(id);
	}
	
	@PostMapping("/{id}/submit")
	public String calculateResult(@PathVariable long id,@RequestBody List<ResponseDto> response) {
		
		return service.calculateResult(id, response);
	}

}

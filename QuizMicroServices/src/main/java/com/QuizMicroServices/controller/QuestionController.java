package com.QuizMicroServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuizMicroServices.DTO.QuestionDto;
import com.QuizMicroServices.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	QuestionService serivce;
	
	
	@PostMapping("/add")
	public QuestionDto addQuestion(@RequestBody QuestionDto questionDto) {
		
		return serivce.addQuestion(questionDto);
	}
	
	@GetMapping("/getAll")
	public List<QuestionDto> getAllQuestions(){
		
		return serivce.getAllQuestions();
	}
	
	@GetMapping("/getCategory/{category}")
	public List<QuestionDto> getCategory(@PathVariable String category){
		
		return serivce.getAllByCategory(category);
	}
}

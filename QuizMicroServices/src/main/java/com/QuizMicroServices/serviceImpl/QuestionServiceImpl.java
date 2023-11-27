package com.QuizMicroServices.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizMicroServices.DTO.QuestionDto;
import com.QuizMicroServices.model.Question;
import com.QuizMicroServices.repository.QuestionRepo;
import com.QuizMicroServices.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	QuestionRepo questionRepo;

	@Override
	public QuestionDto addQuestion(QuestionDto questionDto) {
		
		Question qus = new Question();
		
		qus.setTitle(questionDto.getTitle());
		qus.setOption1(questionDto.getOption1());
		qus.setOption2(questionDto.getOption2());
		qus.setOption3(questionDto.getOption3());
		qus.setAnswer(questionDto.getAnswer());
		qus.setCategory(questionDto.getCategory());
		qus.setLevel(questionDto.getLevel());
		
		Question question = questionRepo.save(qus);
		
		return qusDto(question);
	}

	
	private QuestionDto qusDto(Question question) {

		QuestionDto dto = new QuestionDto();
		
		dto.setTitle(question.getTitle());
		dto.setOption1(question.getOption1());
		dto.setOption2(question.getOption2());
		dto.setOption3(question.getOption3());
		dto.setLevel(question.getLevel());
		dto.setAnswer(question.getAnswer());
		dto.setCategory(question.getCategory());
		dto.setId(question.getId());

		return dto;
	}


	@Override
	public List<QuestionDto> getAllQuestions() {

		List<Question> questions = questionRepo.findAll();
		
		List<QuestionDto> newList = new ArrayList();
		
		for(Question qus : questions) {
			
			QuestionDto questionDto = qusDto(qus);
			
			newList.add(questionDto);
		}
		
		return newList;
	}


	@Override
	public List<QuestionDto> getAllByCategory(String category) {

		List<Question> catQuestion = questionRepo.findByCategory(category);
		
		List<QuestionDto> newList = new ArrayList();
		
		for(Question cat : catQuestion) {
			
			QuestionDto questionDto = qusDto(cat);
			
			newList.add(questionDto);
		}
		
		return newList;	
	}

}

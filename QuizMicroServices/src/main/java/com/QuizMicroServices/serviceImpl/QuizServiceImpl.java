package com.QuizMicroServices.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizMicroServices.DTO.QuestionDto;
import com.QuizMicroServices.DTO.QuizDto;
import com.QuizMicroServices.DTO.QuizWrapperDto;
import com.QuizMicroServices.DTO.ResponseDto;
import com.QuizMicroServices.model.Question;
import com.QuizMicroServices.model.Quiz;
import com.QuizMicroServices.repository.QuestionRepo;
import com.QuizMicroServices.repository.QuizRepo;
import com.QuizMicroServices.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	QuizRepo quizRepo;
	
	@Autowired
	QuestionRepo questionRepo;

	@Override
	public QuizDto createQuiz(String category, int count, QuizDto quizDto) {

		List<Question> questions = questionRepo.findRandomQuestionsByCategory(category ,count);
		
		Quiz quiz = new Quiz();
		
		quiz.setQuizTitle(quizDto.getQuizTitle());
		quiz.setQuestions(questions);
		
		Quiz qz =quizRepo.save(quiz);
		
		return quizDto(qz);

	}

	public QuizDto quizDto(Quiz qz) {
		
		QuizDto dto = new QuizDto();
		
		dto.setId(qz.getId());
		dto.setQuizTitle(qz.getQuizTitle());
		dto.setQuestions(qz.getQuestions());
		
		return dto;
	}
	
	
	
	@Override
	public List<QuizWrapperDto> getQuizQuestions(long id) {

		Optional<Quiz> quiz = quizRepo.findById(id);
		
		List<Question> qusDb = quiz.get().getQuestions();
		
		List<QuizWrapperDto> newList = new ArrayList<QuizWrapperDto>();
		
		for(Question question : qusDb) {
			
			QuizWrapperDto wrapper = new QuizWrapperDto(question.getId(),question.getTitle(),question.getOption1(),question.getOption2(),question.getOption3());
			
			newList.add(wrapper);
		}
		
		return newList;
	}

	
	@Override
	public String calculateResult(long id, List<ResponseDto> responses) {

		Quiz quiz = quizRepo.findById(id).get();
		
		List<Question> questions = quiz.getQuestions();
		
		int index = 0;
		
		int rightAnswer = 0;
		
		for(ResponseDto response : responses) {
			
			if(response.getResponse().equals(questions.get(index).getAnswer())) {
				
				rightAnswer ++;
			}
			
			index ++;
			
		}
		
		return "Total Mark 4 out of :  " + rightAnswer;
		
		
	}

	

}

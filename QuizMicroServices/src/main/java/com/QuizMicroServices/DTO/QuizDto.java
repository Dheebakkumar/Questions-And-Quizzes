package com.QuizMicroServices.DTO;

import java.util.List;

import com.QuizMicroServices.model.Question;

public class QuizDto {   

	private long id;
	
	private String quizTitle;
	
	private List<Question> questions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public QuizDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

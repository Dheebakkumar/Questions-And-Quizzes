package com.QuizMicroServices.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="QUIZ")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="QUIZ_ID")
	private long id;
	
	@Column(name="QUIZ_TITLE")
	private String quizTitle;
	
	@ManyToMany
	@JoinTable(name = "QUESTION_QUIZ", joinColumns = @JoinColumn(name="QUIZ_FK"),inverseJoinColumns = @JoinColumn(name="QUESTION_FK"))
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

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quiz(long id, String quizTitle, List<Question> questions) {
		super();
		this.id = id;
		this.quizTitle = quizTitle;
		this.questions = questions;
	}
	
	
	
}

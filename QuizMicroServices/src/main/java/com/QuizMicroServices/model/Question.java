package com.QuizMicroServices.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="QUESTION")
public class Question {
	
	@Id
	@Column(name = "QUESTION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "QUESTION_TITLE")
	private String title;
	
	@Column(name = "OPTION_1")
	private String option1;
	
	@Column(name = "OPTION_2")
	private String option2;
	
	@Column(name = "OPTION_3")
	private String option3;
	
	@Column(name = "ANSWER")
	private String answer;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "LEVEL")
	private String level;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

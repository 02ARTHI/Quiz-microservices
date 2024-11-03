package com.telusko.quiz_service.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	@ElementCollection
	private List<Integer> questionIDs;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Integer> getQuestionIDs() {
		return questionIDs;
	}
	public void setQuestionIDs(List<Integer> questionIDs) {
		this.questionIDs = questionIDs;
	}
	public Quiz(int id, String title, List<Integer> questionIDs) {
		super();
		this.id = id;
		this.title = title;
		this.questionIDs = questionIDs;
	}
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", questionIDs=" + questionIDs + "]";
	}
	
	
	
}

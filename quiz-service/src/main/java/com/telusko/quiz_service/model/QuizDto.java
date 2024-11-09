package com.telusko.quiz_service.model;

public class QuizDto {

	private String category;
	private int num;
	private String title;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public QuizDto(String category, int num, String title) {
		super();
		this.category = category;
		this.num = num;
		this.title = title;
	}
	public QuizDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "QuizDto [category=" + category + ", num=" + num + ", title=" + title + "]";
	}
	
	
}

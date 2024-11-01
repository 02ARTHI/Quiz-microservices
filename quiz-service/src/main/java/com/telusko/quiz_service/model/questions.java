package com.telusko.quiz_service.model;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class questions {
	
	@Id
	
	private int id;
	private String category;
	private String difficultylevel;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String questiontitle;
	private String rightans;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDifficultylevel() {
		return difficultylevel;
	}
	public void setDifficultylevel(String difficultylevel) {
		this.difficultylevel = difficultylevel;
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
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getQuestiontitle() {
		return questiontitle;
	}
	public void setQuestiontitle(String questiontitle) {
		this.questiontitle = questiontitle;
	}
	public String getRightans() {
		return rightans;
	}
	public void setRightans(String rightans) {
		this.rightans = rightans;
	}
	public questions(int id, String category, String difficultylevel, String option1, String option2, String option3,
			String option4, String questiontitle, String rightans) {
		super();
		this.id = id;
		this.category = category;
		this.difficultylevel = difficultylevel;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.questiontitle = questiontitle;
		this.rightans = rightans;
	}
	public questions() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "questions [id=" + id + ", category=" + category + ", difficultylevel=" + difficultylevel + ", option1="
				+ option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
				+ ", questiontitle=" + questiontitle + ", rightans=" + rightans + "]";
	}
	
    
}

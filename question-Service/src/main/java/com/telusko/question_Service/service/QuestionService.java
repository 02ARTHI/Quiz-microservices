package com.telusko.question_Service.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.question_Service.dao.questiondao;
import com.telusko.question_Service.model.QuestionWrapper;
import com.telusko.question_Service.model.Response;
import com.telusko.question_Service.model.questions;

@Service
public class QuestionService {

	@Autowired
	private questiondao ques;

	public ResponseEntity<List<questions>> getAllQuestions() {
		try
		{
		return new ResponseEntity<>(ques.findAll(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<questions>> getByCategory(String category) {
		try
		{
			return new ResponseEntity<>(ques.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<String> addQuestion(questions ques2) {
		ques.save(ques2);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<Integer>> getQuesForQuiz(String category, int num) {
		List<Integer> question= ques.createAQuizWithNumOfQues(category,num);
		return new ResponseEntity<>(question,HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsForQuiz(List<Integer> quesIDs) {
		List<QuestionWrapper> wrappers = new ArrayList();
		List<questions> quesion = new ArrayList();
		
		for(Integer id : quesIDs)
		{
			quesion.add(ques.findById(id).get());
		}
		
		for(questions questions : quesion)
		{
			 QuestionWrapper wrapper = new QuestionWrapper();
	            wrapper.setId(questions.getId());
	            wrapper.setQuestiontitle(questions.getQuestiontitle());
	            wrapper.setOption1(questions.getOption1());
	            wrapper.setOption2(questions.getOption2());
	            wrapper.setOption3(questions.getOption3());
	            wrapper.setOption4(questions.getOption4());
	            wrappers.add(wrapper);
		}
		return new ResponseEntity<>(wrappers, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		
		int right = 0;

        for(Response response : responses){
        	questions question = ques.findById(response.getId()).get();
            if(response.getResponses().equals(question.getRightans()))
                right++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
	}

}

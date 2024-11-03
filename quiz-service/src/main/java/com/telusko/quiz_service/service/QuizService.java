package com.telusko.quiz_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.quiz_service.dao.QuizDao;
import com.telusko.quiz_service.feign.quizFeign;
import com.telusko.quiz_service.model.QuestionWrapper;
import com.telusko.quiz_service.model.Quiz;
import com.telusko.quiz_service.model.Response;


@Service
public class QuizService {
	
	@Autowired
	private QuizDao quizDao;

	@Autowired
	private quizFeign feign;
	
	public ResponseEntity<String> createQuizFomQuestions(String category, int num, String title) {
		
		List<Integer> questionIDs= feign.getQuestionForQuiz(category,num).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIDs(questionIDs);
		quizDao.save(quiz);
		return new ResponseEntity<>("SUCCESS",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> quesIDs = quiz.getQuestionIDs();
		ResponseEntity<List<QuestionWrapper>> quesForUser = feign.getQuestionsForQuiz(quesIDs);
//		for(questions q : quesFromDB)
//		{
//			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestiontitle());
//			quesForUser.add(qw);
//		}
		return quesForUser;
	}

	public ResponseEntity<Integer> submitQuiz(int id, List<Response> responses) {
		ResponseEntity<Integer> score = feign.getScore(responses);
		return score;
	}

}

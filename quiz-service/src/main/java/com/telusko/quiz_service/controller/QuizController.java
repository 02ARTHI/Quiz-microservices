package com.telusko.quiz_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quiz_service.model.QuestionWrapper;
import com.telusko.quiz_service.model.QuizDto;
import com.telusko.quiz_service.model.Response;
import com.telusko.quiz_service.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto)
	{
		return quizService.createQuizFomQuestions(quizDto.getCategory(),quizDto.getNum(),quizDto.getTitle());
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id)
	{
		return quizService.getQuizQuestions(id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> getQuestions(@PathVariable int id, @RequestBody List<Response> responses)
	{
		return quizService.submitQuiz(id,responses);
	}
}

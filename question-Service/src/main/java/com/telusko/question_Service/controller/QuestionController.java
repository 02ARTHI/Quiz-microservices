package com.telusko.question_Service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.question_Service.model.QuestionWrapper;
import com.telusko.question_Service.model.Response;
import com.telusko.question_Service.model.questions;
import com.telusko.question_Service.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	@GetMapping("/allquestions")
	public ResponseEntity<List<questions>> get()
	{
		return service.getAllQuestions();
//		/return "HI, this is telusko";
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<questions>> getCategory(@PathVariable("category") String category)
	{
		return service.getByCategory(category);
//		/return "HI, this is telusko" ;
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody questions ques2)
	{
		return service.addQuestion(ques2);
//		/return "HI, this is telusko";
	}
	
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category,@RequestParam int num ) 
	{
		return service.getQuesForQuiz(category,num);
	}
	
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsForQuiz(@RequestBody List<Integer> quesIDs)
	{
		return service.getQuestionsForQuiz(quesIDs);
	}
	
	 @PostMapping("getScore")
	    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
	    {
	        return service.getScore(responses);
	    }
}

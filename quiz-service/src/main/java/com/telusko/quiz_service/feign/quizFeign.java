package com.telusko.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.quiz_service.model.QuestionWrapper;
import com.telusko.quiz_service.model.Response;

@FeignClient("question-Service")
public interface quizFeign {

	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category,@RequestParam int num ); 
	
	
	@PostMapping("question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsForQuiz(@RequestBody List<Integer> quesIDs);
	
	
	 @PostMapping("question/getScore")
	    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
	    
}

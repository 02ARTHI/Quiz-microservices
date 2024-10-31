package com.telusko.question_Service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusko.question_Service.model.questions;

@Repository
public interface questiondao extends JpaRepository<questions, Integer> {
  List<questions> findByCategory(String category);
  
 @Query(value="SELECT q.id from questions q WHERE q.category=:category ORDER BY RANDOM() LIMIT :num", nativeQuery=true)
 List<Integer> createAQuizWithNumOfQues(String category, int num);
}

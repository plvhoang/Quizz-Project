package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Quiz;
import com.example.repository.QuizRepository;

@Controller
public class QuizController {
	@Autowired
	QuizRepository quizRepository;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	 public String goHome() {
		 
		 return "redirect:/list-quiz";
	 }
	@RequestMapping(value ="/list-quiz",method = RequestMethod.GET)
	 public String getListQuiz(Model model,@RequestParam(value = "page", defaultValue = "1") int page) {
		 final int maxResult = 4;
		 int maxPage = 1;
		 int total = quizRepository.findAll().size();
		 if((int) total/maxResult <(double) total/maxResult ){
	            maxPage = (int) total/maxResult +1;
	        }else {
	            maxPage = (int) total/maxResult;
	        }
		 model.addAttribute("totalPages",maxPage);
	     model.addAttribute("page",page);
		 Page<Quiz> list =  quizRepository.findAll(PageRequest.of(page-1, maxResult));
		 for(Quiz quiz : list) {
			 System.out.println(quiz.getId());
		 }
		 model.addAttribute("listQuiz", list);
		 return "main";
	 }
	
	@RequestMapping(value = "/quiz",method = RequestMethod.GET)
	 public String getQuiz(Model model,@RequestParam(value = "quizid", defaultValue = "1") long quizid) {
		 Quiz quiz = quizRepository.getById(quizid);
		 model.addAttribute("quiz", quiz);
		 return "index";
	 }
	
}

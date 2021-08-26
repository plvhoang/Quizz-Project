/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Answer;
import com.example.entity.Question;
import com.example.entity.Take;
import com.example.entity.TakeAnswer;
import com.example.repository.AnswerRepository;
import com.example.repository.QuestionRepository;
import com.example.repository.QuizRepository;
import com.example.repository.TakeAnswerRepository;
import com.example.repository.TakeRepository;
import com.example.repository.UserRepository;


@Controller
public class UserController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private TakeRepository takeRepository;
	
	@Autowired 
	private TakeAnswerRepository takeAnswerRepository;
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private UserRepository userRepository;
	//Quiz page
	@RequestMapping(value={"/quiz"},method = RequestMethod.GET )
    public String viewLogin(Model model,@RequestParam(name = "id") String id){
		model.addAttribute("id",id);
        return "index";
    }
	
	@RequestMapping(value={"/end"},method = RequestMethod.GET )
    public String viewEnd(Model model,@RequestParam(name = "id" ,defaultValue = "1") String id){
		model.addAttribute("id",id);
        return "end";
    }
	
	//Question page
	@GetMapping(value = {"/question"})
	public String viewQuestion(Model model,@RequestParam(name="id") long id,@RequestParam(name="questionid",defaultValue = "1") int questionid) {
		List<Question> list_quetionList= questionRepository.findByQuizId(id);
		Long userid = (long) 1;
		Take take = takeRepository.findByUserIdAndQuizId(userid, id);
		if(take == null) {
			take = new Take();
			take.setQuiz(quizRepository.getById(id));
			take.setUser(userRepository.getById(userid));
			takeRepository.save(take);
		}
		
		
//		model.addAttribute("list_quetionList",list_quetionList);
		if(questionid > list_quetionList.size()) {
			return "redirect:/end";
		}
		Question question = list_quetionList.get(questionid-1);
		
		
		List<Answer> listAnswer = answerRepository.findByQuestionId(question.getId());
		
			
		TakeAnswer takeAnswer = new TakeAnswer();
		takeAnswer.setTake(take);		
		takeAnswer.setQuestion(question);
		model.addAttribute("take", take);
		model.addAttribute("listAnswers",listAnswer);
		model.addAttribute("question",question);
		
	    model.addAttribute("id",id);
	    model.addAttribute("questionid",questionid+1);
		return "game";
	}
	@RequestMapping(value={"/question"},method = RequestMethod.POST )
    public String getTakeAnswer (Model model,@RequestParam(name="takeid") long takeid
    		,@RequestParam(name="answer") long answerid,
    		@RequestParam(name="questionid") long questionid,
    		@RequestParam(name="id") long id){
		TakeAnswer takeAnswer = takeAnswerRepository.findByTakeIdAndQuestionId(takeid, questionid-1);
		if(takeAnswer == null) {
			takeAnswer = new TakeAnswer();
			takeAnswer.setTake(takeRepository.getById(takeid));
			takeAnswer.setQuestion(questionRepository.getById(questionid-1));
		}
		takeAnswer.setAnswer(answerRepository.getById(answerid));
		takeAnswerRepository.save(takeAnswer);
        return "redirect:/question?id="+id+"&questionid="+questionid;
    }
}

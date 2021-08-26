package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.entity.Answer;
import com.example.entity.Question;
import com.example.entity.Quiz;
import com.example.entity.User;
import com.example.repository.AnswerRepository;
import com.example.repository.QuestionRepository;
import com.example.repository.QuizRepository;
import com.example.repository.TakeAnswerRepository;
import com.example.repository.TakeRepository;
import com.example.repository.UserRepository;

@Controller
public class QuizManagerController {
	
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
	
	
	
	User getAuthentication(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return userRepository.getByUsername(username);
    }
	
	@RequestMapping(value ="/my-quiz",method = RequestMethod.GET)
	public String getMyquiz(Model model) {
		long userid = getAuthentication().getId();
		List<Quiz> list = quizRepository.findByUserId(userid);
		model.addAttribute("listQuiz", list);
		return "myquiz";
	}
	
	
	@RequestMapping(value ="/edit-quiz",method = RequestMethod.GET)
	public String editquiz(Model model,@RequestParam(value = "quizid",defaultValue = "1")long quizid,
			@RequestParam(value = "questid", defaultValue = "0")long questionid) {
		long userid = getAuthentication().getId();
		Quiz quiz = quizRepository.getById(quizid);
		List<Question> listQuestion = questionRepository.findByQuizId(quizid);
		Question question = null;
		if(questionid == 0) {
			questionid = listQuestion.get(0).getId();
			question=listQuestion.get(0);
		}else {
			question =questionRepository.getById(questionid);
		}
		List<Answer> listAnswer = answerRepository.findByQuestionId(questionid);
		
		System.out.println(listAnswer.size());
		model.addAttribute("listQuestion", listQuestion);
		model.addAttribute("quiz", quiz);
		model.addAttribute("listAnswer", listAnswer);
		model.addAttribute("question", question);
		return "Add_Edit";
	}
	
	
	@RequestMapping(value ="/add-question",method = RequestMethod.POST)
	public String addQuestion(Model model,@RequestParam("quizid") long quizid,
			@RequestParam("questid" ) long questionid,
			@RequestParam("input1") String input1,
			@RequestParam("input2") String input2,
			@RequestParam("input3") String input3,
			@RequestParam("input4") String input4,
			@RequestParam("inputQuestion") String question
			) {
		if(quizid != 0 && questionid != 0) {
			
			System.out.println(question + input1+input2+input3+input4+quizid+questionid);
		}
		System.out.println(question + input1+input2+input3+input4);
		return "redirect:/edit-quiz";
	}
	
	
}

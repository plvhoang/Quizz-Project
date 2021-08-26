package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.naming.java.javaURLContextFactory;
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

import ch.qos.logback.core.joran.conditional.IfAction;

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
		String index ="";
		if(listQuestion == null) listQuestion = new ArrayList<Question>();
		if(questionid == 0 && listQuestion.size()!= 0) {
			questionid = listQuestion.get(0).getId();
			question=listQuestion.get(0);
			model.addAttribute("listQuestion", listQuestion);
			index +=Integer.toString(1);
		}else if(listQuestion.size()!= 0) {
			question =questionRepository.getById(questionid);
			model.addAttribute("listQuestion", listQuestion);
			for(Question question2 : listQuestion) {
				if(question.getId()==questionid) {
					index +=Integer.toString(listQuestion.indexOf(question2));
					
				}
			}
			
		}else {
			question = new Question();
			index = "0";
		}
		index += "/"+ Integer.toString(listQuestion.size());
		List<Answer> listAnswer = answerRepository.findByQuestionId(questionid);
		model.addAttribute("index", index);
		System.out.println(index);
		model.addAttribute("quiz", quiz);
		model.addAttribute("listAnswer", listAnswer);
		model.addAttribute("question", question);
		return "Add_Edit";
	}
	
	
	@RequestMapping(value ="/add-question",method = RequestMethod.POST)
	public String addQuestion(Model model,@RequestParam("quizid") long quizid,
			
			@RequestParam("input1") String input1,
			@RequestParam("input2") String input2,
			@RequestParam("input3") String input3,
			@RequestParam("input4") String input4,
			@RequestParam("inputQuestion") String questionContent,
			@RequestParam("correct") int correct
			) {
		if(quizid != 0) {
			Quiz quiz = quizRepository.getById(quizid);
			System.out.println(questionContent + input1+input2+input3+input4+quizid+correct);
			Question question = new Question();
			question.setContent(questionContent);
			question.setQuiz(quiz);
			question.setScore(1);
			question.setType("multichoise");
			questionRepository.save(question);
			List<String> list = new ArrayList<String>();
			list.add(input1);;
			list.add(input2);
			list.add(input3);
			list.add(input4);
			for(int i =0; i < 4; i++) {
				Answer a1 = new Answer();
				a1.setContent(list.get(i));
				a1.setQuestion(question);
				a1.setQuiz(quiz);
				if(i == correct-1) {
					a1.setCorrect(true);
				}
				answerRepository.save(a1);
			
			}
	
		}
		
		return "redirect:/edit-quiz?quizid="+quizid;
	}
	
	@RequestMapping(value ="/update-answer",method = RequestMethod.POST)
	public String updateQuestion(Model model,@RequestParam("quizid") long quizid,
			@RequestParam("questid") long questionid,
			@RequestParam("input1") String input1,
			@RequestParam("input2") String input2,
			@RequestParam("input3") String input3,
			@RequestParam("input4") String input4,
			@RequestParam("correct") int correct
			) {
		if(quizid != 0) {
			Quiz quiz = quizRepository.getById(quizid);
			System.out.println(input1+input2+input3+input4+quizid);
			Question question = questionRepository.getById(questionid);
			
			List<Answer> listAnswers = question.getListOfAnswers();
			List<String> list = new ArrayList<String>();
			list.add(input1);
			list.add(input2);
			list.add(input3);
			list.add(input4);
			for(int i =0; i < 4; i++) {
				Answer a1 = listAnswers.get(i);
				a1.setContent(list.get(i));
				
				
				if(i == correct-1) {
					a1.setCorrect(true);
				}
				answerRepository.save(a1);
			
			}
//	
		}
		
		return "redirect:/edit-quiz?quizid="+quizid+"&questid="+questionid;
	}
	
	@RequestMapping(value ="/delete-question",method = RequestMethod.GET)
	public String deleteQuestion(Model model,@RequestParam("quizid") long quizid,
			@RequestParam("questid") long questionid) {
		
		Question question = questionRepository.getById(questionid);
		List<Answer> listAnswers = question.getListOfAnswers();
		for(Answer answer : listAnswers) {
			answerRepository.delete(answer);
		}
		questionRepository.delete(question);
		return "redirect:/edit-quiz?quizid="+quizid;
	}
	
	@RequestMapping(value ="/create-quiz",method = RequestMethod.POST)
	public String createQuiz(Model model,@RequestParam("quizName") String quizName) {
		User user = getAuthentication();
		Quiz quiz = new Quiz();
		quiz.setContent(quizName);
		quiz.setUser(user);
		quiz.setTitle(quizName);
		
		quizRepository.save(quiz);
		quiz = quizRepository.findByTitle(quizName);
		
		return "redirect:/edit-quiz?quizid="+quiz.getId();
	}
	
}

package com.mysite.sbb.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping("/question") // 
@Controller
public class QuestionController {
	
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
    private QuestionRepository questionRepository;

    
    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list";
    } 
        
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        
    	
    	Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
    	
    	return "question_detail";
        
    }
}

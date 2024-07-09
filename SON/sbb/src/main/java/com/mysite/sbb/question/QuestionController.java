package com.mysite.sbb.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



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
    	
    @GetMapping("/create")
    public String questionCreate() {
       return "question_form";
        }
    
    
    @PostMapping("/create")
    public String questionCreate(@RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
        
    	// TODO 질문을 저장한다.
    	this.questionService.create(subject, content);
        
    	return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    	// redirect 주소창에 던지는 것 html을 호출하는 것 아님 경우의 수는 2개 html이냔 redirectㅑ
    }
}

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

import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
   
   private final QuestionRepository questionRepository;
   
   @Autowired
   private final QuestionService questionService;
   
   @GetMapping("/list")
   public String list(Model model) {
      List<Question> questionList = this.questionRepository.findAll();
      model.addAttribute("questionList", questionList);
      return "question_list";
   }
   
   @GetMapping(value="/detail/{id}")
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
       return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
   }
   
   @GetMapping(value="/delete/{id}")
   public String delete(@PathVariable("id") Integer id) {
      questionService.delete(id);    
      return "redirect:/question/list";
   }
}

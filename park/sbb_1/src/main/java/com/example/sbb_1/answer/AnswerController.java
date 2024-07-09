package com.example.sbb_1.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sbb_1.question.Question;
import com.example.sbb_1.question.QuestionService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	private final QuestionService questionService;
    private final AnswerService answerService;

	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id,
							   @RequestParam(value="content") String content) {
		 Question question = this.questionService.getQuestion(id);
	        // TODO: 답변을 저장한다. 
	        this.answerService.create(question, content);
	        return "redirect:/question/detail/"+ id;
	}
}

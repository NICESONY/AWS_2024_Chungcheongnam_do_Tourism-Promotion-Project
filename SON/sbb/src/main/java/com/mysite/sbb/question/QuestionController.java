package com.mysite.sbb.question;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/question") //
@Controller
public class QuestionController {

	@Value("${cloud.aws.s3.endpoint}")
	private String downpath;

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
		model.addAttribute("downpath", "https://" + downpath);

		return "question_detail";

	}

	@GetMapping("/create")
	public String questionCreate() {
		return "question_form";
	}

	
	
	@PostMapping("/create")
	public String questionCreate(@ModelAttribute Question question, @RequestParam("file") MultipartFile file)
			throws IOException {

		// TODO 질문을 저장한다.
		questionService.create(question, file);

		return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
		// redirect 주소창에 던지는 것 html을 호출하는 것 아님 경우의 수는 2개 html이냔 redirectㅑ

	}


	 @GetMapping(value = "/delete/{id}") public String delete(Model
	 model, @PathVariable("id") Integer id) {
		 questionService.delete(id);
	
	 
	 return "redirect:/question/list";
	 
	 
	 }
	 
	@GetMapping("/update")
	public String update() {
		return "update_question_form";
	}

	@PostMapping("/update")
	public String update(@RequestParam(value = "subject") String subject,
			@RequestParam(value = "content") String content) {

		
		// TODO 질문을 저장한다.
		this.questionService.update(subject, content);

		return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
		// redirect 주소창에 던지는 것 html을 호출하는 것 아님 경우의 수는 2개 html이냔 redirectㅑ

	}

}

package com.example.naverkakaoexam.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.naverkakaoexam.CustomerService;

@RequestMapping("/product")
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/create")
	public String create() {
		return "product/create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute Product product) {
		
		productService.create(product);
		
		return "redirect:/product/readlist";
	}
	
	@GetMapping("/readlist")
	public String index(Model model) {

		model.addAttribute("products", productService.readlist());
		
		return "product/readlist";
	}
	
	@GetMapping("/readdetail/{id}")
	public String readdetail(Model model, @PathVariable ("id") Integer id) {

		model.addAttribute("product", productService.readdetail(id));
		model.addAttribute("customer", customerService.authen());
		
		return "product/readdetail";
	}
	//키값 밸류값은 RequestParam
	@GetMapping("/result")
	public String result(@RequestParam("imp_uid") String imp_uid)
	{
		System.out.println("카드사로부터 넘어온 결과값 imp_uid"+ imp_uid);
		//최종 승인된 결과값을 새로운 테이블에 기록하고 
		//현재 지불한 회원의 등급을 상향 조정한다.
		customerService.updaterole();
		
		return "redirect:/";
	}
	//@GetMapping("/update")
	
}

package com.mysite.sbb.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	
	@Autowired
	private CateRepository cateRepository;
	
	public void catecreate(Cate cate) {
		cateRepository.save(cate);
	}
	public List<Cate> readlist(){
		return cateRepository.findAll();
	}
}
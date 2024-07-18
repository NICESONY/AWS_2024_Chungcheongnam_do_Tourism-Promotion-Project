package com.example.naverkakaoexam.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void create(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> readlist() {
		return productRepository.findAll();
	}
	
	public Product readdetail(Integer id) {
		Optional<Product> op = productRepository.findById(id);
		return op.get();
	}
	

}

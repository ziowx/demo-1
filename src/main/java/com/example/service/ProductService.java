package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Member;
import com.example.model.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public Product findById(Long id) {
		return productRepository.findById(id).get();
		}

	public List<Product> findByWishMemberNumber(Member member) {
		return productRepository.findByWishMemberNumber(member);
	}


}

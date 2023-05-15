package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Member;
import com.example.model.Product;
import com.example.model.Wish;
import com.example.repository.WishRepository;

@Service
public class WishService {
	
	@Autowired
	private WishRepository wishRepository;

	public Optional<Wish> findById(Long id) {
		return wishRepository.findById(id);
	}

	public void delete(Long id) {
		wishRepository.deleteById(id);		
	}

	public List<Wish> findByMemberMemberNumber(Long memberNumber) {
		return wishRepository.findByMemberMemberNumber(memberNumber);
	}


	public List<Long> findProductIdByMemberMemberNumber(Long memberNumber) {
		return wishRepository.findProductIdByMemberMemberNumber(memberNumber);
	}

	
	
}

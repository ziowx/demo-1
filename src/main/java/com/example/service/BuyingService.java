package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Buying;
import com.example.model.Member;
import com.example.repository.BuyingRepository;

@Service
public class BuyingService {

	@Autowired
	private BuyingRepository buyingRepository;



	public List<Buying> findBuyingByRegistDateBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		return buyingRepository.findByRegistDateBetween(startDateTime, endDateTime);
	}



	public List<Buying> finByMemberMemberNumber(Member member) {
		
		return buyingRepository.findByMemberMemberNumber(member);
	}
}

package com.example.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Buying;
import com.example.model.Member;
import com.example.model.Product;
import com.example.service.BuyingService;
import com.example.service.MemberService;
import com.example.service.ProductService;

@RestController
public class BuyingController {
	
	@Autowired
	private BuyingService buyingService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/api/buying/date")
	public List<Buying> searchDate( @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
	        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate){
		
		LocalDateTime startDateTime = startDate.atStartOfDay();
		LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);
		
		return buyingService.findBuyingByRegistDateBetween(startDateTime, endDateTime);
	}
	
	@GetMapping("/api/get/buying/{memberNumber}")
	public ResponseEntity getBuying(@PathVariable Long memberNumber) {
		Member member = memberService.findByMemberNumber(memberNumber);
		
		List<Buying> lists = buyingService.finByMemberMemberNumber(member);
		
		
		
		return new ResponseEntity<>(lists, HttpStatus.OK);
	}
}

package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Inquiry;
import com.example.model.Member;
import com.example.model.DTO.ImageDTO;
import com.example.model.DTO.InquiryDTO;
import com.example.repository.InquiryRepository;

import jakarta.transaction.Transactional;

@Service
public class InquiryService {

	@Autowired
	private InquiryRepository inquiryRepository;
	
	public Inquiry save(Inquiry addInquiry) {
		return inquiryRepository.save(addInquiry);
	}

	public List<Inquiry> findByMemberMemberNumber(Long memberNumber) {
		return inquiryRepository.findByMemberMemberNumber(memberNumber);
	}

	public Inquiry findById(Long id) {
		return inquiryRepository.findById(id).get();
	}
	
	@Transactional
	public Inquiry update(Long id, String title, Integer category, String content) {
		Inquiry inquiry = inquiryRepository.findById(id).get();
		Inquiry rinquiry = inquiry.update(title, category, content);
		return rinquiry;
	}

	public void delete(Long id) {
		inquiryRepository.deleteById(id);		
	}
	




}

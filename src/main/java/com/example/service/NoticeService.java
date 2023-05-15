package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Notice;
import com.example.repository.NoticeRepository;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;

	public List<Notice> findAll() {
		return noticeRepository.findAll();
	}

	public Notice findById(Long id) {
		return noticeRepository.findById(id).get();
	}

	
	
}

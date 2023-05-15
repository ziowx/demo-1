package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Notice;
import com.example.service.NoticeService;

@RestController
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/api/get/notice")
	public ResponseEntity getNotice() {
		List<Notice> lists = noticeService.findAll();
		
		return new ResponseEntity<>(lists, HttpStatus.OK);
	}
	
	@GetMapping("/api/get/notice/{id}")
	public ResponseEntity getoneNotice(@PathVariable("id") Long id) {
		Notice notice = noticeService.findById(id);
		
		if(notice == null ) {
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<>(notice, HttpStatus.OK);
		
	}
}

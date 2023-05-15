package com.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.model.DTO.InquiryDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="inquiry")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Inquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "member_number", nullable = false)
	private Member member;

	@Column(columnDefinition = "TINYINT", nullable = false)
	private Integer category;
	
	@Column(length = 100, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	@Column(nullable = false)
	private LocalDateTime inquiryRegistDate;
	
	@Column(columnDefinition = "TEXT")
	private String answer;
	
	@Column(columnDefinition = "TINYINT", nullable = false)
	private Integer inquiryStatus;
	
	private LocalDateTime answerRegistDate;
	
	private LocalDateTime answerModifiedDate;

	public Inquiry update(String title, Integer category, String content) {
		this.title=title;
		this.category=category;
		this.content=content;
		return this;
	}
	
}

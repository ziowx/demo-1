package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="image")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TINYINT", nullable = false)
	private Integer pageDiv;
	
	@Column(nullable = false)
	private Long targetId;
	
	@Column(length = 200, nullable = false)
	private String imagePath;
	
	@Column(columnDefinition = "TINYINT", nullable = false)
	private Integer mainImageDiv;
	
	@Column(nullable = false)
	private LocalDateTime registDate;


	public void setTargetId(Long targetId1) {
		this.targetId = targetId1;
		
	}


	
}

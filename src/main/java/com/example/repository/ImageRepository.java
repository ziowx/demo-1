package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Image;
import com.example.model.Inquiry;
import com.example.model.DTO.ImageDTO;

public interface ImageRepository extends JpaRepository<Image, Long> {

	String save(MultipartFile image);

	List<Image> findByTargetId(Long targetId);

	String findByImagePath(String imagePath);

	void save(ImageDTO dto);

	void deleteByTargetId(Long targetId);

}

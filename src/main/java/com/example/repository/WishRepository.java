package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Member;
import com.example.model.Product;
import com.example.model.Wish;

public interface WishRepository extends JpaRepository<Wish, Long> {
	
	List<Wish> findByMemberMemberNumber(Long memberNumber);

	List<Long> findProductIdByMemberMemberNumber(Long memberNumber);



}

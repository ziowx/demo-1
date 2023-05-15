package com.example.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Buying;
import com.example.model.Member;

public interface BuyingRepository extends JpaRepository<Buying, Long> {


	List<Buying> findByRegistDateBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

	List<Buying> findByMemberMemberNumber(Member member);

}

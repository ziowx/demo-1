package com.example.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.model.Inquiry;
import com.example.model.Member;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

	List<Inquiry> findByMemberMemberNumber(Long memberNumber);

	



}

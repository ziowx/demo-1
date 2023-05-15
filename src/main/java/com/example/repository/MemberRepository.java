package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	Member findByPhoneNumber(String phoneNumber);

	Member findByEmailAndPassword(String email, String password);

	Member findByMemberNumber(Long memberNumber);

	Member findByEmail(String email);

	Member findByEmailAndPhoneNumber(String email, String phoneNumber);

	Member findByMemberNumber(String memberNumber);

}

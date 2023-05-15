package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByMemberMemberNumber(Long memberNumber);

	int countByMember_MemberNumber(Long memberNumber);


}

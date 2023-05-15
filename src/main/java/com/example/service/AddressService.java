package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Address;
import com.example.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	public Address save(Address newAddress) {
		return addressRepository.save(newAddress);
	}

	public List<Address> findByMemberMemberNumber(Long memberNumber) {
		return addressRepository.findByMemberMemberNumber(memberNumber);
	}

	public int countByMemberNumber(Long memberNumber) {
		return addressRepository.countByMember_MemberNumber(memberNumber);
	}

}

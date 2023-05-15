package com.example.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Address;
import com.example.model.Member;
import com.example.model.DTO.AddressDTO;
import com.example.service.AddressService;
import com.example.service.MemberService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/api/add/address/{memberNumber}")
	public ResponseEntity addAddress(@PathVariable Long memberNumber, @RequestBody AddressDTO dto) {
		Member member = memberService.findByMemberNumber(memberNumber);
		
		int count = addressService.countByMemberNumber(memberNumber);
		
		if(count >=3) {
			 return new ResponseEntity<>("주소는 3개까지만 등록 가능합니다.", HttpStatus.BAD_REQUEST);
		};
		
		
		String name = dto.getName();
		String address = dto.getAddress();
		String subAddress = dto.getSubAddress();
		String zipCode = dto.getZipCode();
		String phoneNumber = dto.getPhoneNumber();
		Integer defaultAddress = dto.getDefaultAddress();
		LocalDateTime registDate = dto.getRegistDate();
		
		Address newAddress = Address.builder()
						.member(member)
						.name(name)
						.address(address)
						.subAddress(subAddress)
						.zipCode(zipCode)
						.phoneNumber(phoneNumber)
						.defaultAddress(defaultAddress)
						.registDate(registDate)
						.build();
		
		Address result = addressService.save(newAddress);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/api/get/address/{memberNumber}")
	public ResponseEntity getAddress(@PathVariable("memberNumber") Long memberNumber) {
		Member member = memberService.findByMemberNumber(memberNumber);
		List<Address> lists = addressService.findByMemberMemberNumber(member.getMemberNumber());
		
		return new ResponseEntity<>(lists, HttpStatus.OK);
	}
}

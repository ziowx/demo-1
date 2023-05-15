package com.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name="member")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberNumber;
	
	@Column(length = 255, nullable = false, unique = true)
	private String email;
	
	@Column(length = 255, nullable = false)
	private String password;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 11, nullable = false, unique = true)
	private String phoneNumber;
	
	@Column(columnDefinition = "TINYINT", nullable = false)
	private Integer gender;
	
	private LocalDate birthDate;
	
	@Column(columnDefinition = "TINYINT", nullable = false)
	private Integer memberStatus;
	
	@Column(length = 20)
	private String bankName;
	
	@Column(length = 20)
	private String accountNumber;
	
	@Column(length = 50)
	private String depositor;
	
	@Column(nullable = false)
	private LocalDateTime registDate;
	
	private LocalDateTime modifiedDate;

	public Member update(String password, String name, String phoneNumber, String bankName, String accountNumber,
			String depositor, LocalDateTime modifiedDate) {
		this.password=password;
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.bankName=bankName;
		this.accountNumber=accountNumber;
		this.depositor=depositor;
		this.modifiedDate=modifiedDate;
		
		return this;
	}
	

	
}

package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Member;
import com.example.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {


	@Query("SELECT DISTINCT p FROM Product p JOIN FETCH p.wishs w WHERE w.member = :member")
	List<Product> findByWishMemberNumber(@Param("member") Member member);

}

package com.example.securityexam;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	Optional<Member> findByusername(String username); // login check

}

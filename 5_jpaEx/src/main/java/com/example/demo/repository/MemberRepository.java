package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{

	//JPQL
	@Query(value="select m from Member m where m.username = ?1 and m.password = ?2")
	Member jpqlQueryUser(String username, String password);
	
	//SQL
	@Query(value="select * from member where username = ?1 and password = ?2", nativeQuery = true)
	Member sqlQueryUser(String username, String password);
	
//	//SQL
//	@Query(value="select * from member where username = ?1", nativeQuery = true)
//	Member sqlQueryUsername(String username);
	Member findByUsername(String username);
}

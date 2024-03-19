package com.stmproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stmproject.model.STM;

@Repository
public interface STM_RegistrationRepository extends JpaRepository<STM, String>{
	
	@Query(value = "select * from STM where STM_No=?1",nativeQuery = true)
	public STM existsByStmNo(String stmNo);

	@Query(value = "select MAX(no) from STM", nativeQuery = true)
	public Optional<Integer> findMaxCustomFieldValue();

}

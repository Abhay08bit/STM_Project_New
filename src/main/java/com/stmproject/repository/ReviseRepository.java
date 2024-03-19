package com.stmproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stmproject.model.STM;

@Repository
public interface ReviseRepository extends JpaRepository<STM, String> {		
	  
	@Query(value = "SELECT * FROM STM WHERE STM_No = :stmNo", nativeQuery = true)
	  Optional<STM> findByStmNo(@Param ("stmNo") String id);
		
}

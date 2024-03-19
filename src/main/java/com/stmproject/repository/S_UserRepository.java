package com.stmproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stmproject.model.STM;

@Repository
public interface S_UserRepository extends JpaRepository<STM, String> {
	@Query(nativeQuery = true, value = "Select * from dbo.STM where STM_No like ?% and is_deleted='0' ORDER BY no")
	public List<STM> findAllByRelatedValue(String stmNo);

	@Query(nativeQuery = true, value = "Select * from dbo.STM where is_deleted='0' ORDER BY no")
	public List<STM> findAllValues();

}

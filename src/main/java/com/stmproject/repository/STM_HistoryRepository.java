package com.stmproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stmproject.model.STM_Histo;

public interface STM_HistoryRepository extends JpaRepository<STM_Histo, Integer> {

}

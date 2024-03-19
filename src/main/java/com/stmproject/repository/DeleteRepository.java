package com.stmproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stmproject.model.STM;

@Repository
public interface DeleteRepository extends JpaRepository<STM, String> {

}

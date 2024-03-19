package com.stmproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stmproject.model.M_User;
@Repository
public interface M_UserRepository extends JpaRepository<M_User, String> {
	
	 M_User findBySsoid(String ssoid);

}

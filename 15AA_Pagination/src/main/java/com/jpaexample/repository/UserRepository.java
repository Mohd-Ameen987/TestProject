package com.jpaexample.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpaexample.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
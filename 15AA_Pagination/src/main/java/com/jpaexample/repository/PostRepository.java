package com.jpaexample.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpaexample.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    //Add a method to fetch paginated data using Spring Data JPA's Pageable interface.
	Page<Post> findAll(Pageable pageable);
}
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface StudentRepository extends JpaRepository<Student, Long> {
//    Page<Student> findByNameContaining(String name, Pageable pageable); // Example query
//}

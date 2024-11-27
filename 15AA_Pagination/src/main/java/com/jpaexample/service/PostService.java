package com.jpaexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.jpaexample.entity.User;
import com.jpaexample.entity.Post;
import com.jpaexample.repository.PostRepository;
import com.jpaexample.repository.UserRepository;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public Post createPost(Long userId, Post post) {
        // Fetch the user by ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Set the user for the post
        post.setUser(user);

        // Save the post in the repository
        return postRepository.save(post);
    }
    
    
    //Pageable provides pagination details like page number and size.
    //PageRequest.of(page, size) creates a pagination request.
    public Page<Post> getAllPosts(int page, int size) {
    	Pageable pageable = PageRequest.of(page, size);
        return postRepository.findAll(pageable);
    }
}



///
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StudentService {
//    
//    @Autowired
//    private StudentRepository studentRepository;
//
//    public Page<Student> getStudentsWithPagination(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size); // Page index starts from 0
//        return studentRepository.findAll(pageable);
//    }
//}

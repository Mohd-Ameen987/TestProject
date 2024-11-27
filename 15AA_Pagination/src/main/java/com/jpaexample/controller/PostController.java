package com.jpaexample.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jpaexample.entity.Post;
import com.jpaexample.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    // Create a new Student along with College
    @PostMapping("/users/{userId}")
    public ResponseEntity<Post> addPost(@PathVariable Long userId, @RequestBody Post post) {
        Post createdPost = postService.createPost(userId, post);
        return ResponseEntity.ok(createdPost);
    }

    
    
    //Expose an API endpoint for paginated results.
    //The Page object includes the content, total pages, and metadata.\
    //The API uses @RequestParam for flexibility in defining page and size.
    @GetMapping
    public Page<Post> getPosts(@RequestParam(defaultValue="0")int page,
    		@RequestParam(defaultValue="10")int size) throws Exception {
        return postService.getAllPosts(page, size);
    }
    
    
    
    /*

    // Update an existing Student and College
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Post studentDetails) throws Exception {
        studentService.updateStudent(id, studentDetails);
        return ResponseEntity.ok("Student and College updated successfully!");
    }

    // Delete a Student (and related College due to CascadeType.ALL)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) throws Exception {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student and College deleted successfully!");
    }*/
    
}



/**
 {
    "title": "New Post Title",
    "content": "Content of the new post."
}

 * 
 * 
 * */
 
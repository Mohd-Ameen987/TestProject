package com.jpaexample.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaexample.entity.User;
import com.jpaexample.entity.Post;
import com.jpaexample.repository.UserRepository;


@Service
public class UserService {

	
	
	
	
    @Autowired
    private UserRepository userRepository;

    
    
    
    
    
    
    
    public User saveUser(User user) {
    	   List<Post> posts = user.getPosts();
          
          if (posts != null) {
        	   for (Post post : posts) {
                   post.setUser(user); // Set the user for each post in the list
               }
          }
        return userRepository.save(user);
    }
    
    
    
    
    
    
    
    

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

	public Optional<User> getUserById(Long id) {
		
		 return userRepository.findById(id);
	}

	public User updateUser(Long userId, User updatedUserData) {
		// Find the existing user by ID
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Update the basic fields of the user (like name and others)
        existingUser.setName(updatedUserData.getName());
        
        List<Post> updatedPosts = updatedUserData.getPosts();
        if (updatedPosts != null) {
            // Clear existing posts
            existingUser.getPosts().clear();
            
            // Set the user for each post and add to user's post list
            for (Post post : updatedPosts) {
                post.setUser(existingUser);  // Set the user for each post
                existingUser.getPosts().add(post);  // Add post to user's post list
            }
        }

        // Save and return the updated user
        return userRepository.save(existingUser);
    }

	public void deleteUser(Long id) throws Exception {
		User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception("College not found with id: " + id));
        userRepository.delete(user);
		
	}

}
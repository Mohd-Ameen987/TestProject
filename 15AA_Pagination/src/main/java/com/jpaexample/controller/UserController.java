package com.jpaexample.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jpaexample.entity.User;
import com.jpaexample.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

	  @Autowired
	    private UserService userService;
	  
	  
	  
	  
	  

    // Create a new College along with Student
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
    	 userService.saveUser(user);
        return ResponseEntity.ok("Record Inserted successfully");
    }
 
    
    @GetMapping
    public ResponseEntity<List<User>> getUsers() throws Exception {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    // Get a User by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) throws Exception {
        Optional<User> user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    
    
    // Update an existing User
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(user);
    }
    
    
    // Delete a College (and related Student due to CascadeType.ALL)
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws Exception {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully!");
    }
 
    
}


/*

POST
URL - http://localhost:8081/users


//data without post
{
 
    "name": "Rafeeq Bhai",
    "posts": []
}



//data with post
{
   
    "name": "shafeeq bhai",
    "posts": [
        {
            "title": "First Post",
            "content": "This is the content of the first post."
        }
    ]
}




PUT
{
  
    "name": "nawab",
    "posts": [
        {
           
            "title": "Post nawab",
            "content": "This is the content of the post."
        },
      {
           
            "title": "Post new nawab",
            "content": "This is the content of the  post."
        }
    ]
}

 *
 */
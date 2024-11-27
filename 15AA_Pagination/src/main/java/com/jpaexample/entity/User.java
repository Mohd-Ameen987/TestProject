package com.jpaexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //name

    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //orphanRemoval = true
    private List<Post> posts;

    // Constructors, Getters, and Setters
    
}
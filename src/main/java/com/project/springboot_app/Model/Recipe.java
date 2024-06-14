package com.project.springboot_app.Model;

//import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Recipe {
    @Id
// @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private String username;
    private String password;
    
}

package com.project.springboot_app.Model;

import jakarta.persistence.Column;
//import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RecipeDetails {
    @Id
// @GeneratedValue(strategy = GenerationType.AUTO)//generate auto id

    private Integer recipe_id;

    private String recipeName;
    //ALTER TABLE recipe_details MODIFY recipe_description LONGTEXT;
    @Column(columnDefinition="LONGTEXT")
    private String recipe_description;
    @Column(columnDefinition = "LONGTEXT")
    private String recipe_preparation;
    @Column(columnDefinition = "LONGTEXT")
    private String image;
    
    // @Override
	// public String toString() {
	// 	return "Product [id=" + recipe_id + ", name=" + recipe_name + ", description=" 
	//             + recipe_description + ",  image="
	// 			+ image + "]";
	// }
	

}
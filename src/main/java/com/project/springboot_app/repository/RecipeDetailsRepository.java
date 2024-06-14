package com.project.springboot_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.springboot_app.Model.Recipe;
import com.project.springboot_app.Model.RecipeDetails;

@Repository
public interface RecipeDetailsRepository extends JpaRepository<RecipeDetails, Integer>{

<<<<<<< HEAD
    // public List<RecipeDetails> findByRecipeNameContaining(String keywords);

    // @Query("SELECT a FROM recipe_details WHERE"+
    //         "LOWER(a.recipe_name) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " + 
    //         "LOWER(a.recipe_preparation) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " + 
    //         "LOWER(a.recipe_description) LIKE LOWER(CONCAT('%', :searchText, '%'))" )
    // List<RecipeDetails> findRecipesBySearchText(@Param("searchText") String searchText);
=======
   List<RecipeDetails>findByRecipeNameContainingIgnoreCase(String query);


 
>>>>>>> e0f3730 (update)
}
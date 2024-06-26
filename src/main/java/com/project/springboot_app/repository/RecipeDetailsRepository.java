package com.project.springboot_app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.project.springboot_app.Model.RecipeDetails;

@Repository
public interface RecipeDetailsRepository extends JpaRepository<RecipeDetails, Integer>{

   List<RecipeDetails>findByRecipeNameContainingIgnoreCase(String query);
  List<RecipeDetails> findByCategoryIgnoreCase(String category); //category we want to search
  List<RecipeDetails>findByOriginIgnoreCase(String origin);
  // List<RecipeDetails>findByCategoryIgnoreCaseAndContainingNameIgnoreCase(String category,String query);
   


 
}
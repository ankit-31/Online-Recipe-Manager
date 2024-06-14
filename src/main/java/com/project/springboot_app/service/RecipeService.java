package com.project.springboot_app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import com.project.springboot_app.Model.Recipe;
import com.project.springboot_app.Model.RecipeDetails;


@Service
public interface RecipeService {


   // public  Recipe create(Recipe recipe);

   // public void delete(Recipe recipe);
     public RecipeDetails saveRecipe(MultipartFile image, Integer recipe_id, String recipe_name, String recipe_description, String recipe_preparation);

     public List<RecipeDetails> getAllRecipe();

    public void deleterecipeById(Integer recipe_id);

    public void updaterecipeById(Integer recipe_id,RecipeDetails recipeDetails);
    public RecipeDetails getRecipeById(Integer id);
<<<<<<< HEAD
    // List<RecipeDetails> searchRecipes(String searchText);
=======
    public List<RecipeDetails> searchRecipes(String query);
>>>>>>> e0f3730 (update)
}

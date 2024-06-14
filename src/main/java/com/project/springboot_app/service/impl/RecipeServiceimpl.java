package com.project.springboot_app.service.impl;

import java.util.Base64;
import java.util.List;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.project.springboot_app.Model.RecipeDetails;
import com.project.springboot_app.repository.RecipeDetailsRepository;
//import com.project.springboot_app.repository.RecipeRepository;
import com.project.springboot_app.service.RecipeService;

@Service
public class RecipeServiceimpl implements RecipeService {

   // @Autowired
   // RecipeDetails recipeDetails;
   // private RecipeRepository recipeRepository;

    @Autowired
    public RecipeDetailsRepository recipeDetailsRepository;
    //  @Override
    // public Recipe create(Recipe recipe) {
       
    //     return recipeRepository.save(recipe);
    // }

    @Override
    public RecipeDetails saveRecipe(MultipartFile image, Integer recipe_id, String recipeName,
                                    String recipe_description, String recipe_preparation) {
        RecipeDetails r = new RecipeDetails();


        @SuppressWarnings("null")
        String imageName = StringUtils.cleanPath(image.getOriginalFilename());

        if (imageName == null || imageName.contains("..")) {
            throw new IllegalArgumentException("Invalid file: " + imageName);
        }

        try {
            r.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Failed to process image", e);
        }

        r.setRecipe_description(recipe_description);
        r.setRecipe_id(recipe_id);
        r.setRecipeName(recipeName);
        r.setRecipe_preparation(recipe_preparation);

        return recipeDetailsRepository.save(r);
    }
    public List<RecipeDetails> getAllRecipe(){
        return  recipeDetailsRepository.findAll();
    }
    @Override
    public void deleterecipeById( Integer recipe_id) {
       
       recipeDetailsRepository.deleteById(recipe_id);
    }

<<<<<<< HEAD
    // public List<RecipeDetails> listAll(String keyword){
    //     if(keyword!= null){
    //         return recipeDetailsRepository.search(keyword);
    //     }
    // }

    // @Override
    // public List<RecipeDetails> searchRecipes(String searchText){
    //     return recipeDetailsRepository.findRecipesBySearchText(searchText);
    // }
=======
public List<RecipeDetails> searchRecipes(String query) {
        // Implement the search logic here. For example:
        return recipeDetailsRepository.findByRecipeNameContainingIgnoreCase(query);
    }
>>>>>>> e0f3730 (update)

    public RecipeDetails getRecipeById(Integer id) {
        return recipeDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
    }

    public void updaterecipeById(Integer id, RecipeDetails updatedRecipeDetails) {
        RecipeDetails existingRecipe = recipeDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        existingRecipe.setRecipeName(updatedRecipeDetails.getRecipeName());
        existingRecipe.setRecipe_description(updatedRecipeDetails.getRecipe_description());
        existingRecipe.setRecipe_preparation(updatedRecipeDetails.getRecipe_preparation());

        if (updatedRecipeDetails.getImage() != null && !updatedRecipeDetails.getImage().isEmpty()) {
            existingRecipe.setImage(updatedRecipeDetails.getImage());
        }

        recipeDetailsRepository.save(existingRecipe);
       
    }
  

    
}

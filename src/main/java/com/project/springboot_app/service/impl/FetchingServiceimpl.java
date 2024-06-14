package com.project.springboot_app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot_app.Model.Recipe;
import com.project.springboot_app.repository.RecipeRepository;
import com.project.springboot_app.service.FetchingService;
@Service
public class FetchingServiceimpl implements FetchingService {
  
    @Autowired
     RecipeRepository recipeRepository;
    @Override
    public boolean authenticate(Integer id, String username, String password) {
        Optional<Recipe> optionalrecipe=recipeRepository.findById(id);//SELECT * FROM recipe WHERE id = ?;
        if(optionalrecipe.isPresent()){
            Recipe recipe=optionalrecipe.get();
            if(recipe.getPassword().equals(password)&&recipe.getUsername().equals(username)){
                return true;
            }
        }
    
        return false;
    }
    
}




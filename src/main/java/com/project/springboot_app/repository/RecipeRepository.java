package com.project.springboot_app.repository;
import com.project.springboot_app.Model.*;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
                                     
public interface RecipeRepository extends CrudRepository<Recipe,Integer>{
    
}

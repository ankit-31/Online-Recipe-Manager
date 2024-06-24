package com.project.springboot_app.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import com.project.springboot_app.Model.Recipe;
import com.project.springboot_app.Model.RecipeDetails;
import com.project.springboot_app.service.FetchingService;
import com.project.springboot_app.service.RecipeService;


import jakarta.servlet.http.HttpSession;

//import com.project.springboot_app.service.RecipeService;
//import javax.servlet.http.HttpSession;




@Controller

public class FetchingController {
      @Autowired
     FetchingService fetchingService;
     @Autowired
     RecipeService recipeService;

     RecipeDetails recipeDetails;


   
    @GetMapping("/login")
    public String index(){
        return"index";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session ,Model model){

   

            session.removeAttribute("is_authenticated");
            List<RecipeDetails> allrecipe=recipeService.getAllRecipe();
      Random randomRecipe = new Random();
      
      List<RecipeDetails> randomrecipe = new ArrayList<>();
      
      int i = randomRecipe.nextInt(allrecipe.size());
      int j = randomRecipe.nextInt(allrecipe.size());
      while(j == i){
        j = randomRecipe.nextInt(allrecipe.size());
      }
      int k = randomRecipe.nextInt(allrecipe.size());
      while(k == i | k == j){
        k = randomRecipe.nextInt(allrecipe.size());
      }
      randomrecipe.add(allrecipe.get(i));
      randomrecipe.add(allrecipe.get(j));
      randomrecipe.add(allrecipe.get(k));

      
      
      model.addAttribute("recipeItems", randomrecipe);

      return "home";}

          
    

   

//    public Recipe saveRecipe(@RequestParam Recipe recipe){
//       return recipeService.create(recipe);
//     }
@PostMapping("/admin")

public String authenticateUser(@ModelAttribute("loginForm") Recipe loginForm,Model model, HttpSession session) {



    boolean authenticatedUser = fetchingService.authenticate(loginForm.getId(),loginForm.getUsername(), loginForm.getPassword());
   // List<RecipeDetails>=  recipeDetailsRepository.findAll();
    
    System.out.println("i am nopeeeeeeeeeee");
    List<RecipeDetails> allrecipe=recipeService.getAllRecipe();
    System.out.println("value of all recipe is "+allrecipe);
    
    if (authenticatedUser) {

        session.setAttribute("is_authenticated", true);

        
           


    model.addAttribute("recipeItems",allrecipe);
        return "recipelist"; //admin page
    } else {
        session.setAttribute("is_authenticated", false);
        return "unsucess"; 
    }
}

}
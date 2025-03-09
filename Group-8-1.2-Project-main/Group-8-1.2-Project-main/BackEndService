package edu.cmcc.cpt.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecipeRepository {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRepositories() {
    return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
    return recipeRepository.findById(id).orElse(Null);
    }

     public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);

    }
}

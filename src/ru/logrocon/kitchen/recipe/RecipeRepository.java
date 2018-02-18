package ru.logrocon.kitchen.recipe;

import java.util.Map;
import java.util.HashMap;

public class RecipeRepository {

    private Map<String, Recipe> recipes = new HashMap<>();

    public void put(Recipe recipe){
        recipes.put(recipe.getName(), recipe);
    }

    public Recipe get(String name){
        return recipes.get(name);
    }

    public boolean has(String name){
        return recipes.containsKey(name);
    }
}

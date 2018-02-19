package ru.logrocon.kitchen.recipe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RecipeRepository {

    private Map<String, Recipe> recipes;

    public RecipeRepository(){
        toggleStorageType();
    }

    public void put(Recipe recipe){
        recipes.put(recipe.getName(), recipe);
    }

    public String toggleStorageType(){
        if(recipes == null) {
            recipes = new HashMap<>();
            return "HashMap";
        }

        if(recipes instanceof HashMap){
            recipes = (recipes.size() == 0) ? new TreeMap<>() : new TreeMap<>(recipes);
            return "TreeMap";
        }else{
            recipes = (recipes.size() == 0) ? new HashMap<>() : new HashMap<>(recipes);
            return "HashMap";
        }
    }

    public Recipe get(String name){
        return recipes.get(name);
    }

    public Set<String> getNames(){
        return recipes.keySet();
    }

    public boolean has(String name){
        return recipes.containsKey(name);
    }

    public void clear(){
        recipes.clear();
    }
}

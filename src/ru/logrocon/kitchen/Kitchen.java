package ru.logrocon.kitchen;

import ru.logrocon.kitchen.recipe.RecipeRepository;
import ru.logrocon.kitchen.recipe.RecipeUtils;

public class Kitchen {

    private RecipeRepository recipes = new RecipeRepository();

    public Kitchen(){
        // Заполняем кухню рецептами
        recipes.put(RecipeUtils.getBorschRecipe());
        recipes.put(RecipeUtils.getOmeletRecipe());
        recipes.put(RecipeUtils.getVinaigretteRecipe());
    }

    public Food getFood(String foodName){
        return Food.getByRecipe(recipes.get(foodName));
    }

    public static void main(String[] args){
        Kitchen k = new Kitchen();
        k.getFood("Борщ");
    }
}

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

    public Food generateRandomFood(){
        return Food.getByRecipe(RecipeUtils.getFakeRecipe());
    }

    public void printMenu(){
        System.out.println("Меню кухни:");
        for(String name: recipes.getNames()){
            System.out.printf("\t%s;\n", name);
        }
    }
}

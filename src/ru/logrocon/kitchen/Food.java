package ru.logrocon.kitchen;

import ru.logrocon.kitchen.ingredient.Ingredient;
import ru.logrocon.kitchen.recipe.Recipe;

import java.util.ArrayList;

public final class Food {

    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    private String name;

    private Food(String name){
        this.name = name;
    }

    public static Food getByRecipe(Recipe recipe) {
        if (recipe == null) return null;

        Food food = new Food(recipe.getName());

        recipe.getCookSteps().forEach(cookStep -> cookStep.doStep(food));

        return food;
    }

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    public ArrayList<Ingredient> getIngredients(){
        return ingredients;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(getName());
        if(!getIngredients().isEmpty()){
            result.append("\nСостав:");
            for(Ingredient ingredient : getIngredients()){
                result.append("\n\t").append(ingredient.getName());
            }
        }

        return result.toString();
    }
}

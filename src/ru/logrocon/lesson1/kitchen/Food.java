package ru.logrocon.lesson1.kitchen;

import ru.logrocon.lesson1.kitchen.ingredient.Ingredient;

import java.util.ArrayList;

public class Food {

    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    private String name;

    private Food(String name){
        this.name = name;
    }

    public static Food getByRecipe(Recipe recipe) {
        Food food = new Food(recipe.getName());

        recipe.getSteps().forEach(cookStep -> cookStep.doStep(food));

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

        StringBuilder result = new StringBuilder(this.getName());
        result.append("\nСостав:");
        for(Ingredient ingredient : this.getIngredients()){
            result.append("\n\t").append(ingredient.getName());
        }

        return result.toString();
    }
}

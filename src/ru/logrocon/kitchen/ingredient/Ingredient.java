package ru.logrocon.kitchen.ingredient;

import ru.logrocon.kitchen.Food;
import ru.logrocon.kitchen.CookStep;

public abstract class Ingredient implements CookStep {
    private String name;

    public Ingredient(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Добавляем ингредиент: " + name;
    }

    @Override
    public Food doStep(Food food) {
        System.out.println( "\t" + this );
        food.addIngredient(this);
        return food;
    }
}

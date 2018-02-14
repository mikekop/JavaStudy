package ru.logrocon.lesson1.kitchen.ingredient;

import ru.logrocon.lesson1.kitchen.Food;
import ru.logrocon.lesson1.kitchen.Step;

public abstract class Ingredient implements Step {
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

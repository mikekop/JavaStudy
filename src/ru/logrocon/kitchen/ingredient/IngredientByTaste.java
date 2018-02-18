package ru.logrocon.kitchen.ingredient;

public class IngredientByTaste extends Ingredient {

    public IngredientByTaste(String name){
        super(name);
    }

    @Override
    public String toString(){
        return super.toString() + " по вкусу";
    }
}

package ru.logrocon.lesson1.kitchen.ingredient;

public class IngredientByQuantity extends Ingredient {
    private int quantity = 0;

    public IngredientByQuantity(String name, int quantity){
        super(name);
        this.quantity = quantity;
    }

    public IngredientByQuantity(String name){
        super(name);
    }

    @Override
    public String toString(){
        String result = super.toString();
        if(quantity > 0){
            result += " в количестве " + quantity + " шт";
        }
        return result;
    }
}

package ru.logrocon.kitchen.ingredient;

public class IngredientByWeight extends Ingredient {
    private float weight;

    public IngredientByWeight(String name, float weight){
        super(name);
        this.weight = weight;
    }

    @Override
    public String toString(){
        String result = super.toString();
        if(weight > 0){
            result += " массой " + weight + " гр.";
        }
        return result;
    }
}

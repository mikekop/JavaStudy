package ru.logrocon.lesson1.kitchen;

import ru.logrocon.lesson1.kitchen.process.ProcessMerge;

import java.util.ArrayList;

public class RecipeUtils {

    public static Recipe mergeRecipes(String name, Recipe... recipes){
        ArrayList<Step> steps = new ArrayList<>();
        for(int i = 0; i < recipes.length; i++){
            steps.add(new ProcessMerge(recipes[i].getName(), i+1));
            steps.addAll(recipes[i].getSteps());
        }
        return new Recipe(name, steps);
    }
}

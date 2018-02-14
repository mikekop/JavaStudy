package ru.logrocon.lesson1.kitchen;

import ru.logrocon.lesson1.kitchen.process.ProcessMerge;

import java.util.ArrayList;

public class Recipe {
    private ArrayList<Step> steps;
    private String name;

    Recipe(String name, ArrayList<Step> steps) {
        this(name);
        this.steps = steps;
    }

    Recipe(String name) {
        this.name = name;
        steps = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public Recipe addStep(Step step){
        steps.add(step);

        return this;
    }

    public static Recipe mergeRecipes(String name, Recipe... recipes){
        ArrayList<Step> steps = new ArrayList<>();
        for(int i = 0; i < recipes.length; i++){
            steps.add(new ProcessMerge(recipes[i].getName(), i+1));
            steps.addAll(recipes[i].getSteps());
        }
        return new Recipe(name, steps);
    }

    @Override
    public String toString() {
        return super.toString();
    }


}

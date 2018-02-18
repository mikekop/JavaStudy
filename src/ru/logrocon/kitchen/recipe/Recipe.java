package ru.logrocon.kitchen.recipe;

import ru.logrocon.kitchen.CookStep;

import java.util.ArrayList;

public class Recipe {
    private ArrayList<CookStep> cookSteps;
    private String name;

    Recipe(String name, ArrayList<CookStep> cookSteps) {
        this(name);
        this.cookSteps = cookSteps;
    }

    Recipe(String name) {
        this.name = name;
        cookSteps = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<CookStep> getCookSteps() {
        return cookSteps;
    }

    public Recipe addStep(CookStep cookStep){
        cookSteps.add(cookStep);

        return this;
    }

    @Override
    public String toString() {
        return super.toString();
    }


}

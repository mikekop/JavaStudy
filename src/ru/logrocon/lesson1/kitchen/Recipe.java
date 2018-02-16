package ru.logrocon.lesson1.kitchen;

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

    @Override
    public String toString() {
        return super.toString();
    }


}

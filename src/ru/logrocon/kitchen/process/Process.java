package ru.logrocon.kitchen.process;

import ru.logrocon.kitchen.CookStep;
import ru.logrocon.kitchen.Food;

public class Process implements CookStep {
    private String name;
    private float duration = 0.0f;

    public Process(String name, float duration){
        this(name);
        this.duration = duration;
    }


    public Process(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        String result = "Выполняем: " + name;

        if(duration != 0)
            result += " в течении " + duration + " мин.";

        return result;
    }

    @Override
    public Food doStep(Food food) {
        System.out.println( this );
        return food;
    }
}

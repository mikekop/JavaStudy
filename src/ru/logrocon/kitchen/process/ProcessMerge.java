package ru.logrocon.kitchen.process;

import ru.logrocon.kitchen.CookStep;
import ru.logrocon.kitchen.Food;

public class ProcessMerge implements CookStep {
    private String name;
    private int number;

    public ProcessMerge(String name, int number){
        this.name = name;
        this.number = number;
    }

    @Override
    public Food doStep(Food food) {
        System.out.println( "Готовка " + number + " части блюда: " + name );
        return food;
    }
}

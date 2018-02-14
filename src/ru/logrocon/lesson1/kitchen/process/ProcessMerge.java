package ru.logrocon.lesson1.kitchen.process;

import ru.logrocon.lesson1.kitchen.Food;
import ru.logrocon.lesson1.kitchen.Step;

public class ProcessMerge implements Step {
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

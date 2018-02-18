package ru.logrocon.kitchen;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * Базовый абстрактный класс для еды
 */
public abstract class FoodBase implements Food {

    /**
     * Имя еды
     */
    String name;

    /**
     * Коллекция шагов готовки блюда и необходимых для готовки ингридиентов
     */
    private LinkedHashMap<Step, Collection<String>> steps;

    /**
     * Конструктор позволяющий создать еду с названием
     * @param name имя еды
     */
    protected FoodBase(String name)
    {
        this.name = name;
        steps = new LinkedHashMap<>();
        InitSteps();
    }

    /**
     * Метод готовки
     */
    public void cook() {
        System.out.printf("Готовим блюдо: %1$s\n", name);
        for (Step step :
                steps.keySet()) {
            step.doStep(steps.get(step));
        }
    }

    /**
     * Возвращает имя блюда
     * @return
     */
    public String name() {
        return name;
    }


    /**
     * Метод инициализации шагов готовки блюда
     */
    protected abstract void InitSteps();

    /**
     * Метод добавления шага готовки
     * @param step операция
     * @param ingredients используемые ингридиенты
     */
    protected void addStep(Step step, Collection<String> ingredients){
        steps.put(step, ingredients);
    }

}

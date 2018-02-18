package ru.logrocon.kitchen;

import java.util.Collection;

/**
 * Базовый абстрактный класс шага готовки
 */
public class StepBase implements Step {

    /**
     * Описание действиея на шаге
     */
    private String action;

    /**
     * Конструктор
     * @param action имя дейсвтия
     */
    protected StepBase(String action) {
        this.action = action;
    }

    /**
     * Метод выполняющий обработку ингридиентов, в зависимости от специлизации класса
     * @param ingredients ингридиенты применяемые при выполнении шага
     */
    public void doStep(Collection<String> ingredients) {
        System.out.printf("  Применяем операцию: %1$s\n", action);
        System.out.printf("  К ингридиентам: \n");
        for (String ingredient:
             ingredients) {
            System.out.printf("    %1$s\n", ingredient);
        }
    }
}

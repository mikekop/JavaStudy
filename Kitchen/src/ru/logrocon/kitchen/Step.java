package ru.logrocon.kitchen;

import java.util.Collection;

/**
 * интерфейс описывающий шаг готовки
 */
public interface Step {

    /**
     * Выполнение шага готовки
     * @param ingredients ингридиенты применяемые при выполнении шага
     */
    void doStep(Collection<String> ingredients);
}

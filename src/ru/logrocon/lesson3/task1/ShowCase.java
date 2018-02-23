package ru.logrocon.lesson3.task1;

import ru.logrocon.lesson1.Food;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Интерфейс витрины
 */
public interface ShowCase {

    /**
     * Метод добавления блюда на витрину
     */
    void add();

    /**
     * Метод удаления блюда с витрины
     */
    void remove();

    /**
     * Показать витрину
     */
    void show();

    /**
     * Запускающий метод
     */
    void work();

    /**
     * Ищет блюдо
     */
    void find();
}
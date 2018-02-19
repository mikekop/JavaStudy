package ru.logrocon.showcase;

import ru.logrocon.kitchen.Food;

/**
 * интерфейс для витрины блюд
 */
public interface Showcase {
    /**
     * Метод добавления блюда на витрину
     * @param name имя блюда
     * @param food блюдо
     */
    void add(String name, Food food);

    /**
     * Печать блюд в ветрине
     */
    void print();

    /**
     * Метод поиска еды по названию
     * @param name имя еды для поиска
     * @return найденная еда или null если ничего не найдено
     */
    Food search(String name);
}

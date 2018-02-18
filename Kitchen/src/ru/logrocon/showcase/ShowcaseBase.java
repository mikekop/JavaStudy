package ru.logrocon.showcase;

import ru.logrocon.kitchen.Food;

import java.util.Map;

/**
 * Базовый класс для ветрин на основе Map
 */
public class ShowcaseBase implements Showcase {

    /**
     * Map для хранения ветрины
     */
    protected Map<String, Food> map;

    /**
     * Конструктор
     */
    protected ShowcaseBase() {}

    /**
     * Добавление блюда на ветрину
     * @param name имя блюда
     * @param food блюдо
     */
    @Override
    public void add(String name, Food food) {
        map.put(name, food);
    }

    /**
     * Печать всех блюд ветрины
     */
    @Override
    public void print() {
        for (Map.Entry<String, Food> item : map.entrySet()){
            System.out.printf("  %1$s:%2$s\n", item.getKey(), item.getValue().name());
        }
    }

    /**
     * Поиск блюд на ветрине
     * @param name имя еды для поиска
     * @return
     */
    @Override
    public Food search(String name) {
        return map.getOrDefault(name, null);
    }
}

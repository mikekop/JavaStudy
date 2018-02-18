package ru.logrocon.kitchen;

import java.util.Arrays;

/**
 * Класс отвечающий за блюдо Тушеная капуста
 */
public class StewedCabbage extends FoodBase {

    /**
     * Конструктор по умолчанию
     */
    public StewedCabbage() {
        super("Тушеная капуста");
    }

    /**
     * Метод описывающий рецепт готовки
     */
    @Override
    protected void InitSteps() {
        addStep(new RoastStep(), Arrays.asList("Лук", "Мясо"));
        addStep(new BoiledStep(), Arrays.asList("Обжаренное с луком мясо", "Капуста", "Морковь", "Соль"));
    }

}

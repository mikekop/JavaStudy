package ru.logrocon.kitchen;

import java.util.Arrays;

/**
 * Класс описывающий блюдо борщ
 */
public class Borsch extends FoodBase {

    /**
     * Конструктор по умолчанию
     */
    public Borsch() {
        super("Борщ");
    }

    /**
     * Метод описывающий рецепт готовки
     */
    @Override
    protected void InitSteps() {
        addStep(new RoastStep(), Arrays.asList("Лук", "Морковь"));
        addStep(new BraisedStep(), Arrays.asList("Пассированные луке и морковь", "Томатная паста"));
        addStep(new BoiledStep(), Arrays.asList("Мясо"));
        addStep(new BoiledStep(), Arrays.asList("Мясо", "Пережарка", "Капуста", "Свекла", "Соль"));
    }
}

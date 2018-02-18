package ru.logrocon.kitchen;

import java.util.Arrays;

public class PorkChop  extends FoodBase {

    /**
     * Конструктор по умолчанию
     */
    public PorkChop() {
        super("Свинная отбивная");
    }

    /**
     * Метод описывающий рецепт готовки
     */
    @Override
    protected void InitSteps() {
        addStep(new RoastStep(), Arrays.asList("Мясо", "Перец", "Горчица"));
    }
}

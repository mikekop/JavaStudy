package ru.logrocon.kitchen;

/**
 * Класс описывающий блюдо борщ
 */
public class Borsch extends FoodBase implements BoiledFood, RoastFood {

    /**
     * Конструктор по умолчанию
     */
    Borsch() {
        super("Борщ");
    }

    /**
     * Метод осуществляющий операцию жарки во время приготовления борща
     */
    public void roast() {
        System.out.println("Жарим пережарку из свеклы, лука, морковки");
    }

    /**
     * Метод осуществляющий операцию варки во время приготовления борща
     */
    public void boil() {
        System.out.println("Варим мясо и добавляем пережарку");
    }
}

package ru.logrocon.kitchen;

/**
 * Класс отвечающий за блюдо Тушеная капуста
 */
public class StewedCabbage extends FoodBase implements RoastFood, BraisedFood {

    /**
     * Конструктор по умолчанию
     */
    StewedCabbage() {
        super("Тушеная капуста");
    }

    /**
     * Метод отвечающий за приготовление жаркой
     */
    public void roast() {
        System.out.println("Обжариваем мясо");
    }

    /**
     * Метод отвечающий за приготовление тушением
     */
    public void braise() {
        System.out.println("Тушим обжаренное мясо с капустой");
    }
}

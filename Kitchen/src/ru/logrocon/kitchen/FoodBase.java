package ru.logrocon.kitchen;

/**
 * Базовый абстрактный класс для еды
 */
public class FoodBase implements Food {

    /**
     * Имя еды
     */
    String name;

    /**
     * Конструктор позволяющий создать еду с названием
     * @param имя еды
     */
    protected FoodBase(String name)
    {
        this.name = name;
    }

    /**
     * Метод готовки, определяет какие интерфейсы готовки поддерживает наше блюдо и вызывает соответствующие методы приготовления
     */
    public void cook() {
        System.out.printf("Готовка блюда: %1$s\n", name);
        if (this instanceof BoiledFood) {
            ((BoiledFood) this).boil();
        }
        if (this instanceof BraisedFood) {
            ((BraisedFood) this).braise();
        }
        if (this instanceof RoastFood) {
            ((RoastFood) this).roast();
        }
    }
}

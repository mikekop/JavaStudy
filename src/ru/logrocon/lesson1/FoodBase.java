package ru.logrocon.lesson1;

/**
 * Базовый класс для блюд
 */
public abstract class FoodBase implements Food {
    protected String name;


    public void cook() throws FoodException {
        try {
            System.out.println(String.join(" ", name, prepare()));
            System.out.println(String.join(" ", name, finish()));
        }
        catch (FoodException fe)
        {
            System.out.println(fe.getMessage());
            throw new FoodException(name + " приготовить нельзя");
        }
    }

    /**
     * Метод готовки
     */
    protected abstract String prepare() throws FoodException ;

    /**
     * Метод окончания готовки
     */
    protected abstract String finish();

    @Override
    public String toString() {
        return name;
    }
}

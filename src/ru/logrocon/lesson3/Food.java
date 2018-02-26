package ru.logrocon.lesson3;

public interface Food {
    /*
    * Название блюда
     */
    String getName();
    /*
    * Получение информации об еде
     */
    String getInfo();
    /*
    * Приготовление еды
     */
    void cook() throws FoodException;
}

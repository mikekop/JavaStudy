package ru.logrocon.kitchen;

/**
 * интерфейс поддерживающий метод готовки еды
 */
public interface Food {
    /**
     * Метод готовки еды
     */
    void cook();

    /**
     * Возвращает имя блюда
     * @return
     */
    String name();
}

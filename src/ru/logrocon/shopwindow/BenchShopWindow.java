package ru.logrocon.shopwindow;

import ru.logrocon.utils.PerfomanceMeter;

import java.util.Random;

class BenchShopWindow {
    private static final int COUNT_TO_FILL = 1000000;
    private static final int COUNT_TO_SEARCH = 1000000;
    private static Random rand = new Random();
    private static PerfomanceMeter p = new PerfomanceMeter();

    static void bench(ShopWindow window){
        System.out.println("Текущий тип хранилища: " + window.getStorageType());
        System.out.println("\tЗаполняем хранилище: " + COUNT_TO_FILL + " элементов");
        p.start();
        window.cookRandomFoods(COUNT_TO_FILL);
        p.stop("\tВремя заполнения");
        int size = window.size();
        System.out.printf("\tПоиск %d случайных элементов\n", COUNT_TO_SEARCH);
        p.start();
        for(int i = 0; i < COUNT_TO_SEARCH; i++){
            window.buy(String.valueOf(rand.nextInt(size)));
        }
        p.stop("\tВремя поиска");
    }

}

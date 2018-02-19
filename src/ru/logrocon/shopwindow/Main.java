package ru.logrocon.shopwindow;

import ru.logrocon.kitchen.CookQueue;
import ru.logrocon.kitchen.Food;
import ru.logrocon.kitchen.Kitchen;

import static ru.logrocon.shopwindow.BenchShopWindow.bench;

public class Main {

    public static void main(String[] args) {

        if(args.length > 0){
            switch (args[0]){
                case "testQueue":
                    testCookQueue();
                    break;
                default:
                    benchShop();
            }
        }else{
            benchShop();
        }
    }

    private static void benchShop(){
        ShopWindow window = new ShopWindow();
        bench(window);
        window.resetStorageType();
        bench(window);
    }

    private static void testCookQueue(){
        CookQueue queue = new CookQueue();
        Kitchen k = new Kitchen();
        Food f = k.generateRandomFood();
        System.out.println("В очередь " + f);
        queue.sendToCook(f);
        f = k.generateRandomFood();
        System.out.println("В очередь " + f);
        queue.sendToCook(f);
        System.out.println("Из очереди " + queue.getFromCook());
        f = k.generateRandomFood();
        System.out.println("В очередь " + f);
        queue.sendToCook(f);
        f = k.generateRandomFood();
        System.out.println("В очередь " + f);
        queue.sendToCook(f);
        f = k.generateRandomFood();
        System.out.println("В очередь " + f);
        queue.sendToCook(f);
        System.out.println("Из очереди " + queue.getFromCook());
        System.out.println("Из очереди " + queue.getFromCook());
        System.out.println("Из очереди " + queue.getFromCook());
        f = k.generateRandomFood();
        System.out.println("В очередь " + f);
        queue.sendToCook(f);
        System.out.println("Из очереди " + queue.getFromCook());
    }
}

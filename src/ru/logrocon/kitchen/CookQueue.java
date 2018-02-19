package ru.logrocon.kitchen;

import ru.logrocon.utils.Queue;

public class CookQueue {
    private Queue<Food> queue = new Queue<>();

    public void sendToCook(Food food){ queue.push(food); }

    public Food getFromCook(){ return queue.pull(); }
}

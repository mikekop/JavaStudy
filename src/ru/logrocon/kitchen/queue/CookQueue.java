package ru.logrocon.kitchen.queue;

import ru.logrocon.kitchen.Food;
import ru.logrocon.utils.Queue;

public class CookQueue {
    private int size;
    private Queue<Food> queue = new Queue<>();

    public CookQueue(int size) throws IncorrectQueueSizeException{
        if(size < 1){
            throw new IncorrectQueueSizeException("Размер очереди готовки должен быть > 0");
        }
        this.size = size;
    }

    public void sendToCook(Food food) throws QueueOverflowException{
        if(getCount() < getSize()){
            queue.push(food);
        }else {
            throw new QueueOverflowException("Очередь на готовку преполнена. Вместительность: " + getSize());
        }
    }

    public Food getFromCook() throws EmptyQueueException{
        if(getCount() == 0){
            throw new EmptyQueueException("Очередь на готовку пуста");
        }
        return queue.pull();
    }

    public int getCount(){ return queue.getSize(); }

    public int getSize(){ return size; }
}

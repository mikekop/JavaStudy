package ru.logrocon.lesson2;

import java.util.LinkedList;
import java.util.Queue;

public class QueueWorkerImpl implements Worker {
    Queue<Food> queue;
    public QueueWorkerImpl() {
        queue = new LinkedList<>();
    }
    public void start() {
        add(new Course("Борщ", Types.First,Types.Hot, Types.NoLite));
        add(new Course("Омлет", Types.Second, Types.Hot, Types.Lite));
        add(new Course("Шашлык", Types.Second, Types.Hot, Types.Lite));
        add(new Course("Эклер", Types.Desert, Types.NoHot));
        add(new Course("Ватрушка", Types.Desert, Types.NoHot));
        cook();
        cook();
        cook();
        cook();
        cook();
        cook();
        cook();
    }
    public void add(Food food){
        queue.add(food);
    }
    public void cook() {
        if (queue.size() != 0) {
            Food food = queue.remove();
            if (food != null) {
                food.cook();
            }
        }
        else {
            System.out.println("Кончилось все");
        }
    }
}

package ru.logrocon.lesson3;

import java.util.LinkedList;
import java.util.Queue;

import static ru.logrocon.lesson3.Utils.printError;

public class QueueWorkerImpl implements Worker {
    Queue<Food> queue;
    public QueueWorkerImpl() {
        queue = new LinkedList<>();
    }
    @Override
    public void start()  throws ArgumentNullException{
        add(new Course("Борщ", Types.First,Types.Hot, Types.NoLite));
        add(new Course("Омлет", Types.Second, Types.Hot, Types.Lite));
        add(new Course("Шашлык", Types.Second, Types.Hot, Types.Lite));
        add(new Course("Эклер", Types.Desert, Types.NoHot));
        add(new Course("Ватрушка", Types.Desert, Types.NoHot));
        for (int x = 0; x < 999; x = x + 1) {
            try {
                cook();
            }
            catch (EmptyQueueException ex) {
                printError(ex);
                break;
            }
            catch (ArgumentNullException ex) {
                printError(ex);
                break;
            }
            catch (FoodException ex) {
                printError(ex);
            }
        }
    }
    public void add(Food food){
        queue.add(food);
    }
    public void cook() throws ArgumentNullException, EmptyQueueException, FoodException {
        if (queue.size()!=0)
        {
            Food food = queue.remove();
            if (food != null) {
                food.cook();
            }
            else {
                throw new ArgumentNullException("food");
            }
        }
        else {
            throw new EmptyQueueException();
        }
    }
}

package syncstart;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

    private static Integer count=0;
    private final Integer id = ++count;

    @Override
    public void run() {
        System.out.println(this + " стартовала " + System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "Задача №"+id;
    }
}

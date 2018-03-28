package deadlock;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class ClassA {

    synchronized void beginWork(ClassB b) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        long time = Calendar.getInstance().get(Calendar.MILLISECOND);
        System.out.printf("%s зашел в ClassA.beginWork %s \r\n", threadName, time);
        System.out.printf("%s вызывает ClassB.endWork %s \r\n", threadName, time);
        b.endWork();
    }

    synchronized void endWork() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s зашел в ClassA.endWork \r\n", threadName);
    }
}

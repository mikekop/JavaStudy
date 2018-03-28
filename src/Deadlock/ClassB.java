package deadlock;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class ClassB {

    synchronized void beginWork(ClassA a) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        long time = Calendar.getInstance().get(Calendar.MILLISECOND);
        System.out.printf("%s зашел в ClassB.beginWork %s \r\n", threadName, time);
        System.out.printf("%s вызывает ClassA.endWork %s \r\n", threadName, time);
        a.endWork();
    }

    synchronized void endWork() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s зашел в ClassB.endWork \r\n", threadName);
    }
}

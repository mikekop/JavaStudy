package Deadlock;

import java.util.concurrent.TimeUnit;

public class ClassA {

    synchronized void beginWork(ClassB b) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s зашел в ClassA.beginWork \r\n", threadName);

        TimeUnit.SECONDS.sleep(1);

        System.out.printf("%s вызывает ClassB.endWork \r\n", threadName);
        b.endWork();
    }

    synchronized void endWork() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s зашел в ClassA.endWork \r\n", threadName);
    }
}

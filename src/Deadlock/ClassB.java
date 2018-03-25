package Deadlock;

import java.util.concurrent.TimeUnit;

public class ClassB {

    synchronized void beginWork(ClassA a) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s зашел в ClassB.beginWork \r\n", threadName);

        TimeUnit.SECONDS.sleep(1);

        System.out.printf("%s вызывает ClassA.endWork \r\n", threadName);
        a.endWork();
    }

    synchronized void endWork() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s зашел в ClassB.endWork \r\n", threadName);
    }
}

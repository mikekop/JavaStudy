package deadlock;

import simultaneous.Threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Deadlock {
    public Deadlock() {
        ClassA a = new ClassA();
        ClassB b = new ClassB();
        final CountDownLatch start = new CountDownLatch(1);

        WorkerA w1 = new WorkerA(a, b, start);
        WorkerB w2 = new WorkerB(a, b, start);

        Thread t1 = new Thread(w1, "Поток 1");
        Thread t2 = new Thread(w2, "Поток 2");

        t1.start();
        t2.start();
        start.countDown();
    }
}
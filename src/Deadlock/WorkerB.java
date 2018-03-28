package deadlock;

import java.util.concurrent.CountDownLatch;

public class WorkerB implements Runnable {
    private ClassA classA;
    private ClassB classB;
    private CountDownLatch startCountDown;

    public WorkerB(ClassA a, ClassB b, CountDownLatch start){
        classA = a;
        classB = b;
        startCountDown = start;
    }

    @Override
    public void run() {
        try {
            startCountDown.countDown();
            startCountDown.await();
            classB.beginWork(classA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
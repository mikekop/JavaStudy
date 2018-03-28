package deadlock;

import java.util.concurrent.CountDownLatch;

public class WorkerA implements Runnable {
    private ClassA classA;
    private ClassB classB;
    private CountDownLatch startCountDown;

    public WorkerA(ClassA a, ClassB b, CountDownLatch start){
        classA = a;
        classB = b;
        startCountDown = start;
    }

    @Override
    public void run() {
        try {
            startCountDown.await();
            classA.beginWork(classB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
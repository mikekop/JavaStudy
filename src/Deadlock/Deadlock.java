package Deadlock;

public class Deadlock {
    public Deadlock() {
        ClassA a = new ClassA();
        ClassB b = new ClassB();

        WorkerA w1 = new WorkerA(a, b);
        WorkerB w2 = new WorkerB(a, b);


        Thread t1 = new Thread(w1, "Поток 1");
        Thread t2 = new Thread(w2, "Поток 2");

        t1.start();
        t2.start();
    }
}
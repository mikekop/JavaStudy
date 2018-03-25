package Deadlock;

public class WorkerB implements Runnable {
    private ClassA _a;
    private ClassB _b;

    public WorkerB(ClassA a, ClassB b){
        _a = a;
        _b = b;
    }

    @Override
    public void run() {
        try {
            _b.beginWork(_a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
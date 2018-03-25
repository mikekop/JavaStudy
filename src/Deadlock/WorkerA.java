package Deadlock;

public class WorkerA implements Runnable {
    private ClassA _a;
    private ClassB _b;

    public WorkerA(ClassA a, ClassB b){
        _a = a;
        _b = b;
    }

    @Override
    public void run() {
        try {
            _a.beginWork(_b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
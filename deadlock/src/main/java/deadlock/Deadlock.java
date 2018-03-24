package deadlock;

public class Deadlock implements Runnable {

    private FirstClass a = new FirstClass();
    private SecondClass b = new SecondClass();

    @Override
    public void run() {
        b.bar(a);
        System.out.println("Назад в другой поток");
    }

    Deadlock(){
        Thread.currentThread().setName("Главный поток");
        Thread t = new Thread(this, "Соперничающий поток");
        t.start();

        a.foo(b);

        System.out.println("Назад в главный поток");
    }
}
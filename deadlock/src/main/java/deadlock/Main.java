package deadlock;

import java.util.concurrent.CountDownLatch;

public class Main {
    private static CountDownLatch barrier = new CountDownLatch(2);

    public static void main(String[] args) {
        deadlock();
//        withoutDeadlock();
    }

    private static void withoutDeadlock(){

        Object o1 = new Object();
        Object o2 = new Object();

        Thread t = new Thread(()->{
            barrier.countDown();
            try{
                barrier.await();
                synchronized (o1){
                    System.out.println("Поток 1 синхронизируется по 1");
                    synchronized (o2){
                        System.out.println("Поток 1 синхронизируется по 2");
                    }
                }
            }catch (Exception e){}
        });

        t.start();

        Thread t2 = new Thread(()->{
            barrier.countDown();
            try{
                barrier.await();
                synchronized (o1){
                    System.out.println("Поток 2 синхронизируется по 2");
                    synchronized (o2){
                        System.out.println("Поток 2 синхронизируется по 1");
                    }
                }
            }catch (Exception e){}

        });
        t2.start();
    }

    private static void deadlock(){

        Object o1 = new Object();
        Object o2 = new Object();

        Thread t = new Thread(()->{
            barrier.countDown();
            try{
                barrier.await();
                synchronized (o1){
                    System.out.println("Поток 1 синхронизируется по 1");
                    synchronized (o2){
                        System.out.println("Поток 1 синхронизируется по 2");
                    }
                }
            }catch (Exception e){}
        });

        t.start();

        Thread t2 = new Thread(()->{
            barrier.countDown();
            try{
                barrier.await();
                synchronized (o2){
                    System.out.println("Поток 2 синхронизируется по 2");
                    synchronized (o1){
                        System.out.println("Поток 2 синхронизируется по 1");
                    }
                }
            }catch (Exception e){}

        });
        t2.start();
    }
}

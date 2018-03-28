package deadlockWithObj;

import java.util.concurrent.CountDownLatch;

public class DeadLockWithObj {
    private final static CountDownLatch startCDL = new CountDownLatch(2);

    static String str1 = "Строка 1";
    static String str2 = "Строка 2";

    Thread thread1 = new Thread("Поток 1") {
        public void run() {
            try {
                startCDL.countDown();
                startCDL.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (str1) {
                synchronized (str2) {
                    System.out.printf("%s %s %s \r\n",Thread.currentThread().getName(), str1, str2);
                }
            }
        }
    };

    Thread thread2 = new Thread("Поток 2") {
        public void run() {
            try {
                startCDL.countDown();
                startCDL.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (str2) {
                synchronized (str1) {
                    System.out.printf("%s %s %s \r\n",Thread.currentThread().getName(), str2, str1);
                }
            }
        }
    };

    public static void start(){
        DeadLockWithObj deadlock = new DeadLockWithObj();
        deadlock.thread1.start();
        deadlock.thread2.start();
    }
}

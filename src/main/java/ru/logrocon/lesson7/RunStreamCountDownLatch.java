package ru.logrocon.lesson7;

import java.util.concurrent.CountDownLatch;

class RunStreamCountDownLatch implements Runnable{

    static final int countThreads = 4;

    final CountDownLatch latch;

    final int threadNum;

    public RunStreamCountDownLatch(CountDownLatch latch, int threadNum) {
        this.latch = latch;
        this.threadNum = threadNum;
    }

    public void task() {
        for (int i=0;i<1000;i++){
            int temp = 1000/10*58;
        }
    }

    public void run() {
        try {
            latch.countDown();
            latch.await();
            final long startExec = System.currentTimeMillis();
            task();
            System.out.println("Поток № " + this.threadNum + " Старт: " + startExec );
        } catch (InterruptedException  e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(countThreads);
        for(int i=0; i < countThreads; i++) {
            new Thread(new RunStreamCountDownLatch(latch, i)).start();
        }
    }
}

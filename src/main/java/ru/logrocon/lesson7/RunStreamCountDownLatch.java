package ru.logrocon.lesson7;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RunStreamCountDownLatch implements Runnable{

    static final int countThreads = 4;

    final CountDownLatch latch;

    final int threadNum;

    public RunStreamCountDownLatch(CountDownLatch latch, int threadNum) {
        this.latch = latch;
        this.threadNum = threadNum;
    }

    public void task() {
        int temp = 1000/10*58;
    }

    public void run() {
        try {
            final long startExec = System.currentTimeMillis();
            task();
            System.out.println("Поток № " + this.threadNum + " Старт: " + startExec );
        } catch (Exception e) {
            e.printStackTrace();
        }

        latch.countDown();
    }
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(countThreads);

        //создаём пул с потоками
        ExecutorService executor = Executors.newFixedThreadPool(countThreads);

        for(int i=0; i < countThreads; i++) {
            executor.submit(new RunStreamCountDownLatch(latch, i));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

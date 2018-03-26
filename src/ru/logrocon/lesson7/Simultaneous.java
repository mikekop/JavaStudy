package ru.logrocon.lesson7;

import java.util.Random;

public class Simultaneous implements Runnable, Process {
    protected static final int THREADS = 4;


    protected static final Semaphore[] semaphores = new Semaphore[THREADS];
    protected static final Thread[] threads = new Thread[THREADS];

    protected static Random rnd = new Random();

    protected final int threadNum;

    protected Simultaneous(int num) {
        this.threadNum = num;
    }

    public void run() {
        synchronized (semaphores) {
            semaphores[this.threadNum].set = true;
            semaphores.notify();
        }
        final long startExec = System.currentTimeMillis();
        executeTask();
        System.out.println("Поток N" + this.threadNum + ". Время запуска: " + startExec + ".");
    }

    public void executeTask() {
        int temp = 1000;
        for (int i=1; i<rnd.nextInt(temp)*10; i++)
             temp = temp / temp * temp;
    }

    public void start() {
        for (int i=0; i<THREADS; i++) {
            semaphores[i] = new Semaphore();
        }

        System.out.println("Старт " + THREADS + " потоков...");

        synchronized (Simultaneous.class) {
            synchronized (semaphores) {
                for (int i=0; i<THREADS; i++) {
                    final Simultaneous mainThread = new Simultaneous(i);
                    threads[i] = new Thread(mainThread, "Поток N" + i);
                    threads[i].setDaemon(true);
                    threads[i].start();
                }

                boolean isAllStarted = false;
                while (!isAllStarted) {
                    try {
                        semaphores.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    isAllStarted = true;
                    for (int i=0; i<THREADS; i++) {
                        if (!semaphores[i].set) {
                            isAllStarted = false;
                            break;
                        }
                    }
                }
            }
        }
        for (int i=0; i<THREADS; i++) {
            try {
                threads[i].join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
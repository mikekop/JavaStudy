package ru.logrocon.lesson7;

public class RunStreams implements Runnable {
    static final int countThreads = 4;
    
    private static class Flag {
        public boolean set = false;
    }

    static final Flag[] flags = new Flag[countThreads];

    static final Thread[] threads = new Thread[countThreads];

    final int threadNum;

    RunStreams(int num) {
        this.threadNum = num;
    }

    public void run() {
        synchronized (flags) {
            flags[this.threadNum].set = true;
            flags.notify(); //продолжает работу потока, у которого ранее был вызван метод wait()
        }

        final long startExec = System.currentTimeMillis();
        task();
        System.out.println("Поток № " + this.threadNum + " Старт: " + startExec );
    }

    public void task() {
        int temp = 1000/10*58;
    }

    public static void main(String[] args) {
        for (int i = 0; i< countThreads; i++) {
            flags[i] = new Flag();
        }

        synchronized (RunStreams.class) {
            synchronized (flags) {
                for (int i = 0; i< countThreads; i++) {
                    final RunStreams mainThread = new RunStreams(i);
                    threads[i] = new Thread(mainThread, "Thread N" + i); // создаём поток
                    threads[i].start(); // запуск потока
                }
                boolean isAllStarted = false;
                while (!isAllStarted) {
                    try {
//                        переводит вызывающий поток в состояние ожидания до тех пор,
//                                пока другой поток не вызовет метод notify()
                        flags.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    isAllStarted = true;
                    for (int i = 0; i< countThreads; i++) {
                        if (!flags[i].set) {
                            //не все потоки запустились
                            isAllStarted = false;
                            break;
                        }
                    }
                }
            }
        }
    }
}
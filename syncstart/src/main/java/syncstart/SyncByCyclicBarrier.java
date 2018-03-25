package syncstart;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadFactory;

class SyncByCyclicBarrier implements ThreadFactory{

    private CyclicBarrier barrier;

    SyncByCyclicBarrier(Integer countToSync){
        this.barrier = new CyclicBarrier(countToSync);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        return new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("Пытается запуститься поток " + Thread.currentThread().getName());
                    // Встанем в очередь на запуск
                    barrier.await();
                    // Запустимся
                    System.out.println("Запускается поток " + Thread.currentThread().getName());
                    t.start();
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        };
    }
}

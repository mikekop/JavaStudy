package simultaneous;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SimultaneousStart {

    private final CountDownLatch start = new CountDownLatch(4);

    public SimultaneousStart() {
        try {
            Thread[] threads = new Thread[4];
            for (int i = 0; i < threads.length; i++) {
                TimeUnit.SECONDS.sleep(1);
                threads[i] = new Thread(new Threading(i, start));
            }
            for (Thread t : threads) {
                TimeUnit.SECONDS.sleep(1);
                t.start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

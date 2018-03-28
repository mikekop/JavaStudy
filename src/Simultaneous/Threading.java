package simultaneous;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class Threading implements Runnable {

    private int  _num;
    private CountDownLatch _start;

    public Threading(int num, CountDownLatch start){
        _start = start;
        _num = num;
        long time = Calendar.getInstance().get(Calendar.MILLISECOND);
        System.out.printf("Поток: %s. Создание: %s\r\n", _num, time);
    }

    @Override
    public void run() {
        try {
            _start.countDown();
            _start.await();
            long time = Calendar.getInstance().get(Calendar.MILLISECOND);
            System.out.printf("Поток: %s. Запуск: %s\r\n", _num, time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

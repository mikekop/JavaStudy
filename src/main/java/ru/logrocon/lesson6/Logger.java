package ru.logrocon.lesson6;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.concurrent.locks.ReentrantLock;

public class Logger {

    private ReentrantLock locker;
    private String path;
    public Logger(String _path) {
        path = _path;
        locker = new ReentrantLock();
    }

    public void log(String text){
        locker.lock();
        try{
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path, true), "cp1251"));
            writer.print(text);
            writer.flush();
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            locker.unlock();
        }
    }
}

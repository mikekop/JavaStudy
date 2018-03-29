package ru.logrocon.lesson7;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by WD45 on 21.03.2018.
 */
public class Main {

    static A a = new A();
    static B b = new B();

    public static void main (String[] args){

        a.b = b;
        b.a = a;

        //new Locker(a, b).start();

        ReentrantLock locker = new ReentrantLock();

        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.a = a;
        threadB.b = b;

        threadB.locker = locker;
        threadA.locker = locker;





        threadA.start();
        threadB.start();

    }
}

class ThreadA extends Thread{
    A a;
    ReentrantLock locker;
    @Override
    public void run(){
        locker.lock();
        try {
            System.out.println(a.getI());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            locker.unlock();
        }
    }
}

class ThreadB extends Thread{
    B b;
    ReentrantLock locker;
    @Override
    public void run(){
        locker.lock();
        try {
            System.out.println(b.getI());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            locker.unlock();
        }
    }
}

class A {
    B b ;

    public synchronized int getI(){ // залочен
         return b.returnI();
    }

    public synchronized int returnI(){
        return 1;
    }
}

class B {
    A a ;

    public synchronized int getI(){
        return a.returnI();
    }

    public synchronized int returnI(){
        return 2;
    }
}

class Locker extends Thread { // горантированный делок

    private final Object obj1;
    private final Object obj2;

    Locker(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized  (obj1) {
            obj1.notify(); // продолжает работу потока, у которого ранее был вызван метод wait()
            synchronized (obj2) {
                try {
//                    переводит вызывающий поток в состояние ожидания до тех пор,
//                            пока другой поток не вызовет метод notify()
                    obj2.wait();
                }catch (InterruptedException e){}
            }
        }
    }
}

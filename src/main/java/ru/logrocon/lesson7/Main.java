package ru.logrocon.lesson7;

import java.util.concurrent.CountDownLatch;

/**
 * Created by WD45 on 21.03.2018.
 */
public class Main {
    static A a = new A();
    static B b = new B();
    public static void main (String[] args){
        a.b = b;
        b.a = a;

        new Locker(a, b).start();



        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.a = a;
        threadB.b = b;

        threadA.start();
        threadB.start();


    }
}

class ThreadA extends Thread{
    A a;

    @Override
    public void run(){
        System.out.println(a.getI());
    }
}

class ThreadB extends Thread{
    B b;

    @Override
    public void run(){
        System.out.println(b.getI());
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
        synchronized (obj1) {
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

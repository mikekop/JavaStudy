package ru.logrocon.caller;

/**
 * Тестовый класс
 */
public class MyClass {
    public MyClass(){
        System.out.println("Я родился!");
    }
    public MyClass(Boolean param, Integer i, String s, Object o){ System.out.println("Я родился с параметром: " + param); }

    public String testMethod1(String message){
        System.out.println("Вызвался testMethod1: " + message);
        return message;
    }

    public boolean testMethod2(String message, boolean b){
        System.out.println("Вызвался testMethod2: " + message + " " + b);
        return b;
    }
}

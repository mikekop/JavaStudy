package ru.logrocon.utils;

public class Print {
    public static void printErrorMessage(Exception ex){
        System.err.println("Ошибка: " + ex.getMessage());
    }

    public static void println(Object obj){
        System.out.println(obj);
    }
}

package ru.logrocon.lesson1;

import ru.logrocon.lesson1.food.*;

public class Main {

    public static void main(String[] args) {
        // Задача:
        // Смоделировать блюда: печенья, пирожки, первые, вторые.
        // Подготовить иерархию классов. реализация считается успешной, если при вызове метода Cooke,
        // выводится эклер готовится/приготовлен.
        try {
            new Cookie().cook();
            new FirstCourse().cook();
            new Pie().cook();
            new SecondCourse().cook();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
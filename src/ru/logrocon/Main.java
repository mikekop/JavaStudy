package ru.logrocon;

import ru.logrocon.food.*;

public class Main {

    public static void main(String[] args) {
	    // Задача:
        // Смоделировать блюда: печенья, пирожки, первые, вторые.
        // Подготовить иерархию классов. реализация считается успешной, если при вызове метода Cooke,
        // выводится эклер готовится/приготовлен.
        new Cookie().cook();
        new FirstCourse().cook();
        new Pie().cook();
        new SecondCourse().cook();
    }
}

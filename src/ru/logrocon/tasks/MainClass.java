package ru.logrocon.tasks;

public class MainClass {

    private static TaskRunner[] runners = {
            new ru.logrocon.tasks.t1.Runner("Создать класс для хранения трех объектов"),
            new ru.logrocon.tasks.t2.Runner("Создать обобщенный SixTuple"),
            new ru.logrocon.tasks.t3.Runner("Обобщить пример innerclasses/Sequence"),
            new ru.logrocon.tasks.t4.Runner("Модернизация LinkedStack"),
            new ru.logrocon.tasks.t5.Runner("Фибоначчи с композицией"),
    };

    public static void main(String[] args) {
        for (TaskRunner r : runners){
            r.printResult();
        }
    }
}

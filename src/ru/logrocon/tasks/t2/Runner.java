package ru.logrocon.tasks.t2;

import ru.logrocon.tasks.TaskRunner;

public class Runner extends TaskRunner {
    public Runner(String name){ super(name); }

    private <A,B,C,D,E,F> void subTask(A one, B two, C three, D fourth, E five, F six){
        System.out.printf("Заполняем элементами: %s, %s, %s, %s, %s\n",
                one, two, three, fourth, five, six);
        SixTuple<A,B,C,D,E,F> tuple = new SixTuple<>(one, two, three, fourth, five, six);
        System.out.println("Результат:");
        System.out.println(tuple);
    }

    @Override
    protected void run() {
        subTask(1, false, 0.2f, null, 'k', -2);
        subTask(4, 0, "Foo", true, 't', 0.5d);
    }
}

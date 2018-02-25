package ru.logrocon.tasks.t1;

import ru.logrocon.tasks.TaskRunner;

public class Runner extends TaskRunner {
    public Runner(String name){ super(name); }

    private <T> void subTask(T first, T second, T last){
        System.out.printf("Заполняем элементами: %s, %s, %s\n", first, second, last);
        ThreeHolder<T> holder = new ThreeHolder<>(first, second, last);
        System.out.println("Результат:");
        System.out.println("Первый элемент: "+holder.getFirst());
        System.out.println("Второй элемент: "+holder.getSecond());
        System.out.println("Третий элемент: "+holder.getThird());
    }

    @Override
    protected void run() {
        subTask(1,2,3);
        subTask("Один", "Два", "Три");
    }
}

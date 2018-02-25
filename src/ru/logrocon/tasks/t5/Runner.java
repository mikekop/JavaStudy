package ru.logrocon.tasks.t5;

import ru.logrocon.tasks.TaskRunner;

public class Runner extends TaskRunner {
    public Runner(String name){ super(name); }

    @Override
    protected void run() {
        for (Integer i : new IterableFibonacci(18)){
            System.out.print(i + " ");
        }
    }
}

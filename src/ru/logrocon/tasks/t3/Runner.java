package ru.logrocon.tasks.t3;

import ru.logrocon.tasks.TaskRunner;

public class Runner extends TaskRunner {
    public Runner(String name){ super(name); }

    @Override
    protected void run() {
        Sequence<String> sequence = new Sequence<>(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));

        Selector<String> reverseSelector = sequence.reverseSelecor();
        while (!reverseSelector.end()) {
            System.out.print(reverseSelector.current() + " ");
            reverseSelector.next();
        }
        System.out.println();
    }
}

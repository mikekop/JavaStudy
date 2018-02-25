package ru.logrocon.tasks.t4;

import ru.logrocon.tasks.TaskRunner;

public class Runner extends TaskRunner {
    public Runner(String name){ super(name); }

    @Override
    protected void run() {
        LinkedStack<String> lss = new LinkedStack<>();
        for(String s : "А РОЗА УПАЛА НА ЛАПУ АЗОРА".split(" ")){
            lss.push(s);
        }
        String s;
        while ((s = lss.pop()) != null){
            System.out.println(s);
        }
    }
}

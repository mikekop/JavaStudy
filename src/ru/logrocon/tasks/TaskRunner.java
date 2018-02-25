package ru.logrocon.tasks;

public abstract class TaskRunner {
    private String name;

    public TaskRunner(){ this(""); }

    public TaskRunner(String name){
        this.name = name;
    }

    protected abstract void run();

    public final void printResult(){
        System.out.println("Выполнение упражнения: " + name);
        run();
        System.out.println();
    }
}

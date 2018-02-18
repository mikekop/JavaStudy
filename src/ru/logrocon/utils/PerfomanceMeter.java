package ru.logrocon.utils;

public class PerfomanceMeter {
    private long startTime = -1;
    private String name;

    PerfomanceMeter(String name){
        this.name = name;
    }

    public void start(){
        this.startTime = System.currentTimeMillis();
    }

    public void stop(){
        if(startTime < 0){
            System.out.println("Не запущен таймер");
            return;
        }

        double diff = (double)(System.currentTimeMillis() - startTime) / (double)1000;
        System.out.println(name + ": " + diff);
        startTime = -1;
    }
}

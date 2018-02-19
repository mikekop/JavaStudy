package ru.logrocon.utils;

import java.util.Date;

public class PerfomanceMeter {
    private Date startTime;
    private String name;

    public PerfomanceMeter(){}

    public PerfomanceMeter(String name){
        this.name = name;
    }

    public void start(){
        this.startTime = new Date();
    }

    public void stop(){
        stop(this.name);
    }

    public void stop(String nameOfPrint){
        if(startTime == null){
            System.out.println("Не запущен таймер");
            return;
        }
        System.out.printf("%s: %d мс.\n",nameOfPrint, new Date().getTime() - startTime.getTime());
        startTime = null;
    }
}

package ru.logrocon.kitchen.process;

public class ProcessWait extends ru.logrocon.kitchen.process.Process {
    private String waitBefore;

    public ProcessWait(String waitBefore){
        super("Ожидаем");
        this.waitBefore = waitBefore;
    }

    @Override
    public String toString(){
        String result = "Ожидаем";
        if(!waitBefore.isEmpty()){
            result += " пока " + waitBefore;
        }
        return result;
    }
}

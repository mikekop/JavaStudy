package ru.logrocon.lesson1;

public class FirstCourse extends Food {
    public FirstCourse(){
        name = "sdf";
        weight = 151;
    }

    public String displayInfos(){
        return  "Имя:"+name+"\r\n"+"Вес:"+weight;
    }
}

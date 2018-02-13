package ru.logrocon.lesson1;

public class SecondCourse extends Food {
    public SecondCourse(){
        name = "df55555";
        weight = 1571.9;
    }

    public String displayInfos(){
        return  "Имя:"+name+"\r\n"+"Вес:"+weight;
    }
}

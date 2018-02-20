package ru.logrocon.lesson3.kitchen;

public class FirstCourse extends Food {
    public FirstCourse(String name, double weight ){
        this.typeFood = TypeFood.FirstCourse;
        this.name = name;
        this.weight = weight;
    }

    public String displayInfos(){
        return  "Название: "+name+" "+"Вес: "+weight;
    }

    public int compareTo(Food p)
    {
        return name.compareTo(p.name);
    }
}

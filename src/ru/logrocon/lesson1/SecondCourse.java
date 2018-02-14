package ru.logrocon.lesson1;

public class SecondCourse extends Food {

    public double caloricity;

    public SecondCourse(String name, double weight ){
        this.typeFood = TypeFood.SecondCourse;
        this.name = name;
        this.weight = weight;
    }

    public SecondCourse(String name, double weight, double caloricity ){
        this.typeFood = TypeFood.SecondCourse;
        this.name = name;
        this.weight = weight;
        this.caloricity = caloricity;
    }

    public String displayInfos(){

        return caloricity == 0  ? "Название: "+name+" "+"Вес: "+weight
                                : "Название: "+name+" "+"Вес: "+weight+" "+"Калорийность: "+ caloricity;
    }
}

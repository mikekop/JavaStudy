package ru.logrocon.lesson3.exceptions;

import ru.logrocon.lesson3.kitchen.*;

public class CourseByNameException extends Exception {

    Food food;
    public  Food getFood(){return food;}

    public CourseByNameException(String mes, Food food){
        super(mes);
        this.food = food;
    }
}
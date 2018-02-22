package ru.logrocon.lesson3.exceptions;

import ru.logrocon.lesson3.kitchen.*;

public class GetCourseException extends Exception {

    Food food;
    public  Food getFood(){return food;}

    public GetCourseException(String mes, Food food){
        super(mes);
        this.food = food;
    }
}
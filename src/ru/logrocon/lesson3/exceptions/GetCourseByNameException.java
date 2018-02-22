package ru.logrocon.lesson3.exceptions;

import ru.logrocon.lesson3.kitchen.*;

public class GetCourseByNameException extends Exception {

    Food food;
    public  Food getFood(){return food;}

    public GetCourseByNameException(String mes, Food food){
        super(mes);
        this.food = food;
    }
}
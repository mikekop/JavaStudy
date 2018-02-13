package ru.logrocon.lesson1;

import java.util.ArrayList;
import java.util.List;

public class Kitchen implements Kithen {

    private static List<Food> foods ;


    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        foods = new ArrayList<Food>();
        foods.add(new FirstCourse());
        foods.add(new FirstCourse());
        foods.add(new SecondCourse());
        kitchen.displayAllFood();
    }

    public void displayAllFood() {
        foods.forEach(food -> System.out.println(food.displayInfos()));
    }

    public void cook(){

    }
}

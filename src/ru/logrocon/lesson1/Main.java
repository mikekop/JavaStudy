package ru.logrocon.lesson1;

import java.util.ArrayList;

public class Main {
    private static ArrayList<Food> foods;
    public static void main(String[] args) {
        foods = new ArrayList();
        foods.add(new Food( "Борщ"));
        foods.add(new FirstCourse("Щи", true));
        foods.add(new SecondCourse("Плов", false));

        cook();
        System.out.println("Итого");

        printKitchen();
    }

    private static void printKitchen() {
        for(Food food : foods){
            System.out.println(food.getInfo());
        }
    }
    private static void cook() {
        for(Food food : foods){
            food.cook();
        }
    }

}

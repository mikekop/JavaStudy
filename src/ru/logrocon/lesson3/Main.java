package ru.logrocon.lesson3;

import ru.logrocon.lesson3.kitchen.*;
import ru.logrocon.lesson3.exceptions.*;

public class Main {

    static Shopwindows shopwindow;
    static Kitchens kitchen;

    static {
        shopwindow = new Shopwindow();
        kitchen  = new Kitchen();
    }

    public static void main (String[] arg)
    {
        shopwindow.addFood(kitchen.cook(new FirstCourse("Борщ",250 )));
        shopwindow.addFood(kitchen.cook(new SecondCourse("Котлета с пюрешкой",500, 1000 )));
        shopwindow.addFood(kitchen.cook(new SecondCourse("Плов",459, 1500 )));
        shopwindow.addFood(kitchen.cook(new FirstCourse("Щи",400)));
        shopwindow.addFood(kitchen.cook(new FirstCourse("Гароховый суп",458.9)));
        shopwindow.addFood(kitchen.cook(new SecondCourse("Макорошки с подливой",1000)));

        System.out.println(shopwindow.displayAllFood());
        try {
            shopwindow.getCourseByName("Щи");
        }
        catch ( GetCourseByNameException ex ){
            System.out.printf("%s %s\r\n",ex.getMessage(),ex.getFood() == null ? "": ex.getFood().displayInfos());
        }

        System.out.println(shopwindow.displayAllFood());

//        System.out.println(shopwindow.displayAllFood());
//
//        Food food = shopwindow.foodList.pop();
//        System.out.println(food != null ? "Выданно: \r\n" + food.displayInfos() : "Блюдо не найдено");
//        food = shopwindow.foodList.pop();
//        System.out.println(food != null ? "Выданно: \r\n" + food.displayInfos() : "Блюдо не найдено");
//        System.out.println(shopwindow.displayAllFood());
//        System.out.println(shopwindow.displaySortByNameFoods());
//
//        shopwindow.foodList.addLast(new SecondCourse("Макорошки с мясом",1000));
//
//        System.out.println(shopwindow.displayAllFood());
    }


}

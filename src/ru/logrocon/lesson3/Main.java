package ru.logrocon.lesson3;

import ru.logrocon.lesson3.kitchen.*;
import ru.logrocon.lesson3.exceptions.*;

public class Main {

    public static void main (String[] arg)
    {
        Kitchen kitchen = new Kitchen();
        Shopwindow shopwindow = new Shopwindow();

        shopwindow.foodList.addLast(kitchen.cook(new FirstCourse("Борщ",250 )));
        shopwindow.foodList.addLast(kitchen.cook(new SecondCourse("Котлета с пюрешкой",500, 1000 )));
        shopwindow.foodList.addLast(kitchen.cook(new SecondCourse("Плов",459, 1500 )));
        shopwindow.foodList.addLast(kitchen.cook(new FirstCourse("Щи",400)));
        shopwindow.foodList.addLast(kitchen.cook(new FirstCourse("Гароховый суп",458.9)));
        shopwindow.foodList.addLast(kitchen.cook(new SecondCourse("Макорошки с подливой",1000)));

        System.out.println(shopwindow.sortByNameFoods());
        try {
            shopwindow.getCourseByName("Щи");
        }
        catch ( CourseByNameException ex ){
            System.out.println(ex.getMessage() +" "+ ex.getFood().displayInfos());
            if (ex.getFood()!=null)
                shopwindow.foodList.remove(ex.getFood());
        }


        System.out.println(shopwindow.displayAllFood());

        Food food = shopwindow.foodList.pop();
        System.out.println(food != null ? "Выданно: \r\n" + food.displayInfos() : "Блюдо не найдено");
        food = shopwindow.foodList.pop();
        System.out.println(food != null ? "Выданно: \r\n" + food.displayInfos() : "Блюдо не найдено");
        System.out.println(shopwindow.displayAllFood());
        System.out.println(shopwindow.sortByNameFoods());

        shopwindow.foodList.addLast(new SecondCourse("Макорошки с мясом",1000));

        System.out.println(shopwindow.displayAllFood());
    }


}

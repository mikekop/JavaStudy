package ru.logrocon.lesson1;

import java.util.ArrayList;
import java.util.List;

public class Kitchen implements Kitchens {

    private static List<Food> foods ;

    public Kitchen(){
        foods = new ArrayList<>();
    }

    public void displayAllFood() {
        System.out.println("Первые блюда");
        foods.forEach(food ->{
            if (food.typeFood == TypeFood.FirstCourse)
            {
                System.out.println(food.displayInfos());
            }
        });
        System.out.println("Вторые блюда");
        foods.forEach(food ->{
            if (food.typeFood == TypeFood.SecondCourse)
            {
                System.out.println(food.displayInfos());
            }
        });
    }

    public void cook(Food food){
        foods.add(food);
    }

    public boolean eatFood(TypeFood typeFood)
    {
        List<Food> foodList = new ArrayList<>();
        foodList.addAll(foods);
        for (Food food:foodList) {
            if (food.typeFood == typeFood){
                foods.remove(food);
                System.out.println("Скушанно: "+food.name);
                return true;
            }
        }
        System.out.println("Еды нет!");
        return false;
    }
}

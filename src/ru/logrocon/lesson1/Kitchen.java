package ru.logrocon.lesson1;

import java.util.ArrayList;
import java.util.List;

public class Kitchen implements Kithen {

    private static List<Food> foods ;

    public Kitchen(){
        foods = new ArrayList<>();
    }

    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        kitchen.cook(new FirstCourse("Борщ",250 ));
        kitchen.cook(new SecondCourse("Котлета с пюрешкой",500, 1000 ));
        kitchen.cook(new SecondCourse("Плов",459, 1500 ));
        kitchen.cook(new FirstCourse("Щи",400));
        kitchen.cook(new FirstCourse("Гароховый суп",458.9));
        kitchen.cook(new SecondCourse("Макорошки с подливой",1000));

        kitchen.displayAllFood();
        kitchen.eatFood(TypeFood.SecondCourse);
        kitchen.displayAllFood();
        kitchen.eatFood(TypeFood.FirstCourse);
        kitchen.eatFood(TypeFood.FirstCourse);
        kitchen.eatFood(TypeFood.SecondCourse);
        kitchen.eatFood(TypeFood.FirstCourse);
        kitchen.eatFood(TypeFood.FirstCourse);
        kitchen.displayAllFood();
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
        for (Food food:foods) {
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

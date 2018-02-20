package ru.logrocon.lesson2;

import ru.logrocon.lesson2.kitchen.*;

import java.util.*;

public class Shopwindow implements Shopwindows  {
    public ArrayDeque<Food> foodList;
    TreeSet<Food> foodsTreeSet;

    public Shopwindow(){
        //foodList = new ArrayList<>();
        foodsTreeSet = new TreeSet<>();
        foodList = new ArrayDeque<>();
    }

    public Food getCourseByName (String name) {
        for(Food food : foodList){
            if (food.name == name){
                return food;
            }
        }
        return null;
    }

    public Food getFirstFood()
    {
       return new FirstCourse("Щи",400);
    }
    public String sortByNameFoods(){
        foodsTreeSet.addAll(foodList);
        return displayAll(foodsTreeSet);
    }

    public String displayAllFood(){
        return displayAll(foodList);
    }

    String displayAll (Collection<Food> foods){
        StringBuilder stringBuilder = new StringBuilder("Первые блюда :\r\n");
        StringBuilder firstCourses = new StringBuilder();
        StringBuilder secondCourses = new StringBuilder();
        for(Food food : foods) {
            switch (food.typeFood) {
                case FirstCourse:
                    firstCourses.append(food.displayInfos()+"\r\n");
                    break;
                case SecondCourse:
                    secondCourses.append(food.displayInfos()+"\r\n");
                    break;
            }
        }
        stringBuilder.append(firstCourses.toString());
        stringBuilder.append("Вторые блюда :\r\n");
        stringBuilder.append(secondCourses.toString());
        return stringBuilder.toString();
    }
}

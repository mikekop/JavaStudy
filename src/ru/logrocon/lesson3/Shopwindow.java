package ru.logrocon.lesson3;

import ru.logrocon.lesson3.kitchen.*;
import ru.logrocon.lesson3.exceptions.*;


import java.util.*;

public class Shopwindow implements Shopwindows  {
    public ArrayDeque<Food> foodList;
    TreeSet<Food> foodsTreeSet;

    public Shopwindow(){
        foodsTreeSet = new TreeSet<>();
        foodList = new ArrayDeque<>();
    }

    public void getCourseByName (String name) throws CourseByNameException {
        for(Food food : foodList){
            if (food.name == name){
                throw new CourseByNameException("Выданно блюдо :" , food);
            }
        }
        throw new CourseByNameException("Блюдо не найдено" , null);
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

package ru.logrocon.lesson3;

import ru.logrocon.lesson3.kitchen.*;
import ru.logrocon.lesson3.exceptions.*;


import java.util.*;

public class Shopwindow implements Shopwindows  {
    Queue<Food> foodList;
    TreeSet<Food> foodsTreeSet;

    public Shopwindow(){
        foodsTreeSet = new TreeSet<>();
        foodList = new LinkedList<>();
    }

    public void addFood(Food food){
        foodList.offer(food);
    }

    public void getCourseByName (String name) throws GetCourseException {
        Iterator<Food> foodIterator = foodList.iterator();
        while (foodIterator.hasNext()){
            Food food = foodIterator.next();
            if (food.name == name){
                foodIterator.remove();
                throw new GetCourseException("Выданно блюдо :" , food);
            }
        }
        throw new GetCourseException("Блюдо не найдено", null);
    }

    public void getFirstFood() throws GetCourseException {
        Food food = foodList.poll();
        if(food!=null) {
            throw new GetCourseException("Выданно блюдо :" , food);
        }
        throw new GetCourseException("Блюдо не найдено", null);
    }

    public String displaySortByNameFoods(){
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

package ru.logrocon.lesson3;


import java.util.ArrayList;
import java.util.Scanner;

import static ru.logrocon.lesson3.Utils.printError;

public class FinderWorkerImpl implements Worker {

    ArrayList<Food> foodList;

    public FinderWorkerImpl() {
        foodList = new ArrayList<>();
    }

    public ArrayList<Food> findFoodByName(String name) {
        ArrayList<Food> result = new ArrayList<Food>();
        if (name != null && !name.isEmpty()) {
            for(Food food : foodList){
              if (food.getName().toLowerCase().contains(name.toLowerCase())){
                    result.add(food);
                }
            }
        }
        else {
            System.out.println("Не задан поиск");
        }
        return result;
    }
    @Override
    public void start() {
        try {
            fill();
            find();
        }
        catch (Exception ex) {
            printError(ex);
        }
    }

    public void fill()  throws ArgumentNullException {
        foodList.add(new Course("Окрошка",Types.First, Types.NoHot, Types.Lite));
        foodList.add(new Course("Щи", Types.First, Types.Hot, Types.NoLite));
        foodList.add(new Course("Борщ", Types.First,Types.Hot, Types.NoLite));
        foodList.add(new Course("Омлет", Types.Second, Types.Hot, Types.Lite));
        foodList.add(new Course("", Types.Second, Types.Hot, Types.Lite));
        foodList.add(new Course("Ватрушка", Types.Desert, Types.NoHot));
    }

    public void find() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст для поиска");
        String inputStr = sc.next();
        if(inputStr.isEmpty()) {
            System.out.println("Не введен текст для поиска");
        }
        else {
            ArrayList<Food> result = findFoodByName(inputStr);
            if (result != null) {
                if (result.isEmpty()) {
                    throw new Exception("Ничего не найдено");
                }
                if (result.size() == 1) {
                    System.out.println(String.format("Найден один объект %s", result.get(0).getInfo()));
                }
                else {
                    System.out.println(String.format("Найдено %s элементов", result.size()));
                    System.out.println("Вывести упорядоченно по названию?");
                    System.out.println("1. Да");
                    System.out.println("2. Нет");
                    if(sc.hasNextInt()) {
                        switch (sc.nextInt()) {
                            case 1:
                                result.sort(Utils.NameComparator);
                                break;
                                default:
                                    throw new ArgumentNullException("sort order");
                        }
                    }
                    for (Food food: result) {
                        System.out.println(food.getInfo());
                    }
                }
            }
        }
    }


}

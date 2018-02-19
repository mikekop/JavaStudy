package ru.logrocon.shopwindow;

import ru.logrocon.kitchen.Food;
import ru.logrocon.kitchen.Kitchen;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ShopWindow {
    private Kitchen kitchen = new Kitchen();
    private Map<String, Food> foods;
    private storageType currentType;

    public enum storageType {
        hashMap,
        treeMap
    }

    private void setStorageType(storageType storageType){
        switch (storageType){
            case hashMap:
                foods = new HashMap<>();
                currentType = ShopWindow.storageType.hashMap;
                break;
            case treeMap:
                foods = new TreeMap<>();
                currentType = ShopWindow.storageType.treeMap;
        }
    }

    public ShopWindow(){ this(storageType.treeMap); }

    public ShopWindow(storageType storageType){ setStorageType(storageType); }

    public void resetStorageType() {
        if(currentType == storageType.hashMap){
            setStorageType(storageType.treeMap);
        }else{
            setStorageType(storageType.hashMap);
        }
    }

    public storageType getStorageType(){return currentType;}

    public void cookRandomFoods(int count){

        while (count-- > 0){
            Food food = kitchen.generateRandomFood();
            foods.put(String.valueOf(count), food);
        }
    }

    public Food buy(String key){
        return foods.remove(key);
    }

    public void cook(String key, Food food){
        foods.put(key, food);
    }

    public void clear(){ foods.clear(); }

    public int size(){ return foods.size(); }
}

package ru.logrocon.utils;

import java.util.LinkedList;

public class Queue<Type> {
    private LinkedList<Type> items = new LinkedList<>();

    public void push(Type item){
        items.addLast(item);
    }

    public Type pull(){
        if(isEmpty()) return null;

        return items.removeFirst();
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public int getSize(){
        return items.size();
    }
}

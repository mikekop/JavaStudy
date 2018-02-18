package ru.logrocon.lesson2;

import java.util.ArrayList;

import static ru.logrocon.lesson2.Utils.getTypeName;

public class Course extends FoodImpl {
    private Types[] types;

    Course(String name, Types... types){
        super(name);
        this.types = types;
    }
    @Override
    public String getInfo() {
        return String.format("%s %s", super.getInfo(), getTypeName(types));
    }
}

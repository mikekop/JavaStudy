package ru.logrocon.lesson3;

import static ru.logrocon.lesson3.Utils.getTypeName;

public class Course extends FoodImpl {
    private Types[] types;

    Course(String name, Types... types) throws ArgumentNullException{
        super(name);
        this.types = types;
    }
    @Override
    public String getInfo() {
        return String.format("%s %s", super.getInfo(), getTypeName(types));
    }
}

package ru.logrocon.lesson1;

public class FirstCourse extends Food {
    private boolean IsHot;
    FirstCourse(String name, boolean isHot){
        super(name);
        IsHot = isHot;
    }
    @Override
    public String getInfo() {
        return String.format("%s %s", (IsHot ? "Горячее" : "Холодное"), super.getInfo());
    }
}

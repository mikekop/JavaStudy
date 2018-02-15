package ru.logrocon.lesson1;

public class SecondCourse extends Food {
    private boolean IsLite;
    SecondCourse(String name, boolean isLite) {
        super(name);
        IsLite = isLite;
    }
    @Override
    public String getInfo() {
        return String.format("%s %s", (IsLite ? "Легкое" : "Тяжелое"), super.getInfo());
    }
}

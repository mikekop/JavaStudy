package ru.logrocon.lesson2;

import java.util.Comparator;

public class Utils {
    public static String getTypeName(Types... types) {
        StringBuilder result = new StringBuilder();
        for (Types type: types){
            switch (type) {
                case First:
                    result.append("Первое ");
                    break;
                case Second:
                    result.append("Второе ");
                    break;
                case Desert:
                    result.append("Десерт ");
                    break;
                case Hot:
                    result.append("Горячее ");
                    break;
                case NoHot:
                    result.append("Горячее ");
                    break;
                case Lite:
                    result.append("Горячее ");
                    break;
                case NoLite:
                    result.append("Горячее ");
                    break;
            }
        }
        return result.toString().trim();
    }
    public static Comparator<Food> NameComparator = (f1, f2) -> {
        String Name1 = f1.getName().toUpperCase();
        String Name2 = f2.getName().toUpperCase();
        return Name1.compareTo(Name2);
    };
}

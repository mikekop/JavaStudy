package ru.logrocon.lesson1;

public class Main {
    public static void main (String[] arg)
    {
        Kitchen kitchen = new Kitchen();
        kitchen.cook(new FirstCourse("Борщ",250 ));
        kitchen.cook(new SecondCourse("Котлета с пюрешкой",500, 1000 ));
        kitchen.cook(new SecondCourse("Плов",459, 1500 ));
        kitchen.cook(new FirstCourse("Щи",400));
        kitchen.cook(new FirstCourse("Гароховый суп",458.9));
        kitchen.cook(new SecondCourse("Макорошки с подливой",1000));

        kitchen.displayAllFood();
        kitchen.eatFood(TypeFood.SecondCourse);
        kitchen.displayAllFood();
        kitchen.eatFood(TypeFood.FirstCourse);
        kitchen.eatFood(TypeFood.FirstCourse);
        kitchen.eatFood(TypeFood.SecondCourse);
        kitchen.eatFood(TypeFood.FirstCourse);
        kitchen.eatFood(TypeFood.FirstCourse);
        kitchen.displayAllFood();
    }
}

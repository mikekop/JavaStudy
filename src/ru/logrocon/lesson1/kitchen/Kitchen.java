package ru.logrocon.lesson1.kitchen;


import ru.logrocon.lesson1.kitchen.ingredient.*;
import ru.logrocon.lesson1.kitchen.process.Process;
import ru.logrocon.lesson1.kitchen.process.ProcessWait;

public class Kitchen {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать на кухню!\n");
        System.out.println("Начинаем готовить борщ");

        Recipe bouillon = new Recipe("Варка бульона")
                .addStep(new IngredientByVolume("Вода", 2000))
                .addStep(new IngredientByWeight("Мясо", 400))
                .addStep(new Process("Варка", 150))
                .addStep(new ProcessWait("сварится бульон"))
                .addStep(new Process("Вынимание мяса"))
                .addStep(new IngredientByWeight("Нашинкованная капуста", 300))
                .addStep(new ProcessWait("пройдет 5-10 минут"))
                .addStep(new IngredientByQuantity("Кортофель нарезанный", 4))
                .addStep(new Process("Нарезка и добавление мяса"));

        Process frying = new Process("Жарка на среднем огне", 5);

        Recipe roast = new Recipe("Зажарка")
                .addStep(new IngredientByQuantity("Свекла", 2))
                .addStep(new IngredientByQuantity("Морковь", 1))
                .addStep(new IngredientByQuantity("Лук", 3))
                .addStep(new IngredientByQuantity("Подсолнечное масло"))
                .addStep(frying)
                .addStep(new IngredientByQuantity("Свекла", 2))
                .addStep(frying)
                .addStep(new IngredientByQuantity("Томатная паста", 2))
                .addStep(frying);

        Recipe endOfCook = new Recipe("Завершение готовки")
                .addStep(new IngredientByTaste("Соль"))
                .addStep(new Process("Высыпать зажарку в бульон"))
                .addStep(new IngredientByTaste("Лавровый лист"))
                .addStep(new IngredientByTaste("Мелкопорубленная зелень"))
                .addStep(new ProcessWait("пройдет 5-7 минут"));

        Recipe borsch = Recipe.mergeRecipes("Борщ", bouillon, roast, endOfCook);

        System.out.println("\nМы приготовили " + Food.getByRecipe(borsch));
        System.out.println("\nДо новых встреч на кухне!");
    }
}

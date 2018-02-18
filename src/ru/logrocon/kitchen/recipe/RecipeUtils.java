package ru.logrocon.kitchen.recipe;

import ru.logrocon.kitchen.CookStep;
import ru.logrocon.kitchen.ingredient.*;
import ru.logrocon.kitchen.process.Process;
import ru.logrocon.kitchen.process.ProcessMerge;
import ru.logrocon.kitchen.process.ProcessWait;

import java.util.ArrayList;

public class RecipeUtils {

    private static Recipe mergeRecipes(String name, Recipe... recipes){
        ArrayList<CookStep> cookSteps = new ArrayList<>();
        for(int i = 0; i < recipes.length; i++){
            cookSteps.add(new ProcessMerge(recipes[i].getName(), i+1));
            cookSteps.addAll(recipes[i].getCookSteps());
        }
        return new Recipe(name, cookSteps);
    }

    public static Recipe getBorschRecipe(){

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

        return RecipeUtils.mergeRecipes("Борщ", bouillon, roast, endOfCook);
    }

    public static Recipe getOmeletRecipe(){

        return new Recipe("Омлет")
                .addStep(new IngredientByQuantity("Яйцо", 2))
                .addStep(new IngredientByVolume("Молоко", 60))
                .addStep(new IngredientByTaste("Соль"))
                .addStep(new Process("Перемешать"))
                .addStep(new Process("Вылить смесь в форму"))
                .addStep(new Process("Поставить в духовки на температуру 180-200"))
                .addStep(new ProcessWait("пройдет 15-20 мин"));
    }

    public static Recipe getVinaigretteRecipe(){

        return new Recipe("Винегрет")
                .addStep(new IngredientByWeight("Свекла", 400))
                .addStep(new IngredientByWeight("Морковь", 300))
                .addStep(new IngredientByWeight("Картофель", 400))
                .addStep(new IngredientByWeight("Квашеная капуста", 200))
                .addStep(new IngredientByWeight("Маринованные огурцы", 200))
                .addStep(new IngredientByWeight("Лук", 150))
                .addStep(new Process("Отварить"))
                .addStep(new Process("Нарезать кубиками"))
                .addStep(new IngredientByTaste("Растительное масло"))
                .addStep(new IngredientByTaste("Соль"));
    }
}

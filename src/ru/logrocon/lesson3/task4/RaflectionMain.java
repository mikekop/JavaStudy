package ru.logrocon.lesson3.task4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RaflectionMain {
    public RaflectionMain() {
        try {
            Class myClass = Class.forName("ru.logrocon.lesson3.task4.ReflectionClass");
            System.out.printf("Создали класс %s\r\n", myClass.getClass().getName());

            System.out.println("Доступные методы:");
            for (Method method:
                 myClass.getDeclaredMethods()) {
                System.out.println(method.getName());
            }

            Object instance = myClass.newInstance();
            System.out.println("Вызываем publicMethod");
            Method publicMethod = myClass.getDeclaredMethod("publicMethod");
            publicMethod.invoke(instance);

            System.out.println("Вызываем protectedMethod");
            Method protectedMethod = myClass.getDeclaredMethod("protectedMethod");
            protectedMethod.setAccessible(true);
            protectedMethod.invoke(instance);

            System.out.println("Вызываем privateMethod");
            Method privateMethod = myClass.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(instance);

            System.out.println("Вызываем methodWithParam");
            Class<?>[] paramTypes = {String.class};
            Method methodWithParam = myClass.getDeclaredMethod("methodWithParam", paramTypes);
            methodWithParam.setAccessible(true);
            methodWithParam.invoke(instance, "Параметр");

        } catch (ClassNotFoundException ex) {
            System.err.println("Класс ReflectionClass не найден");
        } catch (NoSuchMethodException ex) {
            System.err.println("Метод не найден");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
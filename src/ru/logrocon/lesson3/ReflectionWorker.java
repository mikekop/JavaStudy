package ru.logrocon.lesson3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionWorker implements Worker {

    public ReflectionWorker() {
    }

    @Override
    public void start() {
        try {
            Class myClass = Class.forName("ru.logrocon.lesson3.CustomClass");
            Object instance = myClass.newInstance();
            String className = instance.getClass().getName();
            System.out.printf("Создали класс %s\r\n", className);

            System.out.printf("методы класса: $s", className);
            for (Method method : myClass.getDeclaredMethods()) {
                System.out.printf("%s %s", method.getName(), method.getParameters().length);
            }
            for (Method method : myClass.getDeclaredMethods()) {
                String methodName = method.getName();
                System.out.printf("Вызываем %s\r\n", methodName);
                Method _method = myClass.getDeclaredMethod(methodName);
                if (!_method.isAccessible()) {
                    _method.setAccessible(true);
                }
                Object  value = _method.invoke(instance);
                if(value!=null){
                    System.out.println(value);
                }
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Класс CustomClass не найден");
        } catch (NoSuchMethodException ex) {
            System.err.println("Метод не найден");
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
        ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
    }
}
}
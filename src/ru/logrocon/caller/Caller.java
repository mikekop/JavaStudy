package ru.logrocon.caller;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class CantCallFromPrimitive extends Exception{
    CantCallFromPrimitive(){super();}
    CantCallFromPrimitive(String message){super(message);}
    CantCallFromPrimitive(Exception e){super(e);}
}

public class Caller {
    private static Pattern p = Pattern.compile("\\w+\\.");
    private static List<Class> numberTypes;
    static {
        numberTypes = new ArrayList<>();
        numberTypes.add(byte.class);
        numberTypes.add(int.class);
        numberTypes.add(long.class);
        numberTypes.add(short.class);
        numberTypes.add(float.class);
        numberTypes.add(double.class);
    }

    private Class<?> cl;
    private Object instance;

    private Caller(Class cl){
        this.cl = cl;
        instance = getInstance();
    }

    /**
     * Построние инстанса объекта, либо значения примитива
     * @return Инстанс объекта или значение примитива
     */
    private Object constructInstance(){
        Object result = null;

        // Попробуем конструктор по дефолту
        try {
            result = cl.newInstance();
            return result;
        }catch (Exception e){
            System.err.println("Не удалось запустить конструктор по умолчанию");
        }

        if(cl.isPrimitive()){
            return Caller.getDefaultForPrimitive(cl);
        }

        if(cl == String.class){
            return "0";
        }

        Constructor[] ctor = cl.getConstructors();
        if(ctor.length > 0) {
            Constructor c = ctor[0];
            Object[] initArgs = getDefaultByTypes(c.getParameterTypes());

            try{
                result = c.newInstance(initArgs);
            }catch (Exception e){
                System.err.println("Не удалось вызвать конструктор");
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    /**
     * Получение значений по умолчанию для примитивов
     * @param c Тип примитива
     * @return Значение по умолчанию для примитива
     */
    @SuppressWarnings("unchecked")
    private static Object getDefaultForPrimitive(Class c){
        if(numberTypes.contains(c) ){ return 0; }
        if(c == boolean.class){ return false; }
        if(c == char.class) { return '\u0000'; }

        return null;
    }

    /**
     * Получение значений по умолчанию для объектов
     * @param types Массив типов
     * @return Массив значений по умолчанию
     */
    private static Object[] getDefaultByTypes(Class[] types){
        Object[] result = new Object[types.length];
        int i = 0;
        for(Class t : types){
            result[i++] = new Caller(t).getInstance();
        }

        return result;
    }

    /**
     * Улучшает читаемость при выводе названий методов
     * @param name Название метода
     * @return Отформатированное название метода
     */
    private static String prettifyName(String name){
        return p.matcher(name).replaceAll("");
    }

    public Caller(String className) throws ClassNotFoundException {
        cl = Class.forName(className);
        instance = getInstance();
    }

    /**
     * Получение инстанса объекта, либо значения примитива
     * @return Инстанс объекта или значение примитива
     */
    public Object getInstance(){
        if(instance == null){
            instance = constructInstance();
        }

        return instance;
    }

    /**
     * Поиск и попытка вызова всех методов инстанса
     * @throws CantCallFromPrimitive При попытке вызвать что-то у примитива
     */
    public void callAll() throws CantCallFromPrimitive{
        if(cl.isPrimitive()) {
            throw new CantCallFromPrimitive("Не могу вызвать метод от примитива");
        }

        Method[] methods = cl.getMethods();
        for (Method m : methods){
            Object[] params = getDefaultByTypes(m.getParameterTypes());
            try {
                System.out.println("Вызываем " + prettifyName(m.toString()) + "...");
                System.out.println("Результат: " + m.invoke(instance, params));
            }catch (Exception e){
                System.err.println("Не удалось вызвать метод " + prettifyName(m.toString()));
            }
        }
    }

    /**
     * Вывод всех методов класса
     */
    public void printMethods(){
        for (Method m : cl.getMethods()){
            System.out.println(prettifyName(m.toString()));
        }
    }

    /**
     * Вывод всех конструкторов класса
     */
    public void printConstructors(){
        for (Constructor ctor : cl.getConstructors()){
            System.out.println(prettifyName(ctor.toString()));
        }
    }
}

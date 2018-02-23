package ru.logrocon.caller;

class MainClass {
    static MyClass c = new MyClass();

    public static void main(String[] args){
        Caller c = null;

        try {
            c = new Caller("ru.logrocon.caller.MyClass");
        }catch (ClassNotFoundException e){
            System.err.println("Не найден класс");
            System.exit(1);
        }

        System.out.println("Методы:");
        c.printMethods();
        System.out.println("Конструкторы:");
        c.printConstructors();

        try {
            c.callAll();
        }catch (CantCallFromPrimitive e){
            System.err.println(e);
        }

    }
}

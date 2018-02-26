package ru.logrocon.lesson3;


import static ru.logrocon.lesson3.Utils.getRandomBoolean;

public class CustomClass {
    private void privateMethod() {
        System.out.println("privateMethod");
    }
    protected void protectedMethod() {
        System.out.println("protectedMethod");
    }
    public void publicMethod() {
        System.out.println("publicMethod");
    }

    public boolean randomBoolean(){
        return getRandomBoolean();
    }

}

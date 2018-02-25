package ru.logrocon.lesson3.task4;

public class ReflectionClass {
    public void publicMethod()
    {
        System.out.println("public метод publicMethod");
    }

    private void privateMethod()
    {
        System.out.println("private метод privateMethod");
    }

    protected void protectedMethod()
    {
        System.out.println("protected метод protectedMethod");
    }

    public void methodWithParam(String a)
    {
        System.out.printf("Метод с параметром (%s)\r\n", a);
    }
}

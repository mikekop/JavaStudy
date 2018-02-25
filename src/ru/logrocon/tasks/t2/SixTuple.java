package ru.logrocon.tasks.t2;

public class SixTuple<A,B,C,D,E,F> {
    public final A one;
    public final B two;
    public final C three;
    public final D fourth;
    public final E five;
    public final F six;

    public SixTuple(A a, B b, C c, D d, E e, F f){
        one = a;
        two = b;
        three = c;
        fourth = d;
        five = e;
        six = f;
    }

    @Override
    public String toString() {
        return String.format("" +
                "(%s, %s, %s, %s, %s, %s)",
                one, two, three, fourth, five, six
        );
    }
}

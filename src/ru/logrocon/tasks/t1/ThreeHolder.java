package ru.logrocon.tasks.t1;

class ThreeHolder<T> extends TwoHolder<T>{
    private T third;

    ThreeHolder(T first, T second, T third){
        super(first, second);
        this.third = third;
    }

    T getThird() { return third; }

    void setThird(T third) { this.third = third; }
}

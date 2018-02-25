package ru.logrocon.tasks.t1;

class TwoHolder<T> extends OneHolder<T> {
    private T second;

    TwoHolder(T first, T second){
        super(first);
        this.second = second;
    }

    T getSecond() { return second; }

    void setSecond(T second) { this.second = second; }
}

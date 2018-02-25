package ru.logrocon.tasks.t1;

class OneHolder<T> {
    private T first;

    OneHolder(T first){
        this.first = first;
    }

    T getFirst() { return first; }

    void setFirst(T first) { this.first = first; }
}
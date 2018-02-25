package ru.logrocon.tasks.t3;

interface Selector<T> {
    boolean end();

    T current();

    void next();
}

public class Sequence<T> {
    private T[] items;
    private int next = 0;

    @SuppressWarnings("unchecked")
    public Sequence(int size) {
        items = (T[])new Object[size];
    }

    public void add(T x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector<T> {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public T current() {
            return items[i];
        }

        public void next() {
            if (i < items.length)
                i++;
        }

    }

    private class ReverseSelector implements Selector<T>{
        private int i = items.length - 1;
        @Override
        public boolean end() {
            return i < 0;
        }

        @Override
        public T current() {
            return items[i];
        }

        @Override
        public void next() {
            if(i >= 0){
                i --;
            }
        }
    }

    public Selector<T> selector() {
        return new SequenceSelector();
    }

    public Selector<T> reverseSelecor(){
        return new ReverseSelector();
    }
}

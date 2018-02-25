package ru.logrocon.tasks.t5;

import java.util.Iterator;

class IterableFibonacci implements Iterable<Integer>{
    private Fibonacci f = new Fibonacci();
    private Integer n;

    IterableFibonacci(int count){ n = count; }

    @Override
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return f.next();
            }
        };
    }
}

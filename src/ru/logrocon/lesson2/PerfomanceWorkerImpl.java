package ru.logrocon.lesson2;

import java.util.*;

public class PerfomanceWorkerImpl implements Worker {

    private Integer countItems;

    PerfomanceWorkerImpl(Integer countItems) {
        this.countItems = countItems == null ? 10000 : countItems;
    }

    @Override
    public void start() {
        Random rand = new Random(25);
        Map<String, String> map = new HashMap<>();
        List<String> arrayList = new ArrayList<>();

        for (int i = 0; i < countItems; i++){
            map.put(Integer.toString(rand.nextInt()), Integer.toString(rand.nextInt()));
            arrayList.add(Integer.toString(rand.nextInt()));
        }


        Date start = new Date();
        String temp = null;
        for (String s : map.keySet()) {
            temp = "key = " + s + ", val " + map.get(s);
        }
        System.out.printf("Длительность исходного метода: %s мс%n", new Date().getTime() - start.getTime());

        start = new Date();
        for (Map.Entry<String, String> s : map.entrySet()) {
            temp = "key = " + s.getKey() + ", val " + s.getValue();
        }
        System.out.printf("Длительность оптимизированного метода: %s мс%n", new Date().getTime() - start.getTime());

        System.out.println("ArrayList");
        start = new Date();
        for (String l : arrayList ) {
            temp = "Value[i] = " + l;
        }
        System.out.printf("Длительность исходного метода: %s мс%n", new Date().getTime() - start.getTime());

        start = new Date();
        for (int i = 0; i < arrayList.size(); i++) {
            temp = "Value[i] = " + arrayList.get(i);
        }

        System.out.printf("Длительность оптимизированного метода: %s мс%n", new Date().getTime() - start.getTime());
    }
}

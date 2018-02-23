package ru.logrocon.lesson2.task3;

import java.util.*;

public class PerfomanceTask {

    public PerfomanceTask(){
        System.out.println("Задача 3. Оптимизация метода");
        Random rand = new Random(47);
        Map<String, String> map = new HashMap<>();
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++){
            map.put(Integer.toString(rand.nextInt()), Integer.toString(rand.nextInt()));
            arrayList.add(Integer.toString(rand.nextInt()));
        }

        for (int i = 0; i < 100000; i++){
            linkedList.add(Integer.toString(rand.nextInt()));
        }

        doIt(map, arrayList, linkedList);
    }

    private void doIt(Map<String, String> map, List<String> arrayList, List<String> linkedList) {
        String temp;

        System.out.println("Перебор map");
        Date start = new Date();
        for (String s : map.keySet()) {
            temp = "key = " + s + ", val " + map.get(s);
        }
        System.out.printf("Длительность исходного метода: %s мс%n", new Date().getTime() - start.getTime());

        start = new Date();
        for (Map.Entry<String, String> s : map.entrySet()) {
            temp = "key = " + s.getKey() + ", val " + s.getValue();
        }
        System.out.printf("Длительность оптимизированного метода: %s мс%n", new Date().getTime() - start.getTime());

        System.out.println("Перебор arrayList");
        start = new Date();
        for (int i = 0; i < arrayList.size(); i++) {
            temp = "Value[i] = " + arrayList.get(i);
        }
        System.out.printf("Длительность исходного метода: %s мс%n", new Date().getTime() - start.getTime());

        start = new Date();
        for (String l : arrayList ) {
            temp = "Value[i] = " + l;
        }
        System.out.printf("Длительность оптимизированного метода: %s мс%n", new Date().getTime() - start.getTime());

        System.out.println("Перебор linkedList");
        start = new Date();
        for (int i = 0; i < linkedList.size(); i++) {
            temp = "Value[i] = " + linkedList.get(i);
        }
        System.out.printf("Длительность исходного метода: %s мс%n", new Date().getTime() - start.getTime());

        start = new Date();
        for (String l : linkedList ) {
            temp = "Value[i] = " + l;
        }
        System.out.printf("Длительность оптимизированного метода: %s мс%n", new Date().getTime() - start.getTime());
    }
}

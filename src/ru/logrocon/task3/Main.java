package ru.logrocon.task3;

import ru.logrocon.utils.PerfomanceMeter;

import java.util.*;

public class Main {

    private static void doIt(Map<String, String> map, List<String> list) {
        for (String s : map.keySet()) {
            System.out.println("key = " + s + ", val " + map.get(s));
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Value[i] = " + list.get(i));
        }
    }

    private static void doItNow(Map<String, String> map, List<String> list) {
        if(map != null){
            for (Map.Entry s : map.entrySet()) {
                System.out.println("key = " + s.getKey() + ", val " + s.getValue());
            }
        }

        if(list != null){
            for (String s2 : list){
                System.out.println("Value[i] = " + s2);
            }
        }
    }

    private static void fillMap(Map<String, String> map, int count){
        if(count <= 0) return;

        for(int i = 0; i < count; i ++){
            String data = UUID.randomUUID().toString();
            map.put(data, data);
        }
    }

    private static void fillList(List<String> list, int count){
        if(count <= 0) return;

        for(int i = 0; i < count; i ++){
            String data = UUID.randomUUID().toString();
            list.add(data);
        }
    }

    public static void main(String[] args) {
        PerfomanceMeter p = new PerfomanceMeter();
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int fillSize = 1000;
        System.out.println(">Заполнение на " + fillSize + " элементов");
        fillMap(map, fillSize);
        fillList(list, fillSize);
        p.start();
        doIt(map, list);
        p.stop(">До оптимизации");
        p.start();
        doItNow(map, list);
        p.stop(">После оптимизации");
    }
}

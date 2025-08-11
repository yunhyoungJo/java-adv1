package thread.collection.java;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class ListMain {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("list = " + list);

        Set<Integer> copySet = new CopyOnWriteArraySet<>();
        copySet.add(3);
        copySet.add(1);
        copySet.add(2);
        System.out.println("copySet = " + copySet);

        //순서정렬
        Set<Object> skipSet = new ConcurrentSkipListSet<>();
        skipSet.add(3);
        skipSet.add(2);
        skipSet.add(1);
        System.out.println("skipSet = " + skipSet);

        Map<Integer, String> map1 = new ConcurrentHashMap<>();
        map1.put(1,"data1");
        map1.put(2,"data2");
        map1.put(3,"data3");
        System.out.println("map1 = " + map1);

        //tree 순서정렬
        Map<Integer , String> map2 = new ConcurrentSkipListMap<>();
        map2.put(2,"data2");
        map2.put(3,"data3");
        map2.put(1,"data1");
        System.out.println("map2 = " + map2);

    }
}

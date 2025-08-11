package thread.collection.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class SyncronizedListMain {

    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        list.add("data1");
        list.add("data2");
        list.add("data3");
        System.out.println(list.getClass());
        System.out.println("list="+list);
    }
}

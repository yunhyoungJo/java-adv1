package thread.collection;

import thread.collection.list.BasicList;
import thread.collection.list.SimpleList;
import thread.collection.list.SyncList;

import static thread.util.MyLogger.log;

public class SimpleListMainV2 {

    public static void main(String[] args) throws InterruptedException {

       test(new SyncList());
    }

    private static void test(SimpleList list) throws InterruptedException {
        log(list.getClass().getSimpleName());

        Runnable runnable1 = ()->{
          list.add("A");
          log("Thread-1: list.add(A)");
        };

        Runnable runnable2 = ()->{
            list.add("B");
            log("Thread-2: list.add(B)");
        };

        Thread thread1 = new Thread(runnable1 , "thread-1");
        Thread thread2 = new Thread(runnable2 , "thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(list);
    }
}

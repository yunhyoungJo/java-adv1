package thread.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class CasMainV3 {

    private static int THREAD_COUNT = 2;

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println("atomicInteger.get() = " + atomicInteger.get());

        Runnable runnable = ()-> incrementAndGet(atomicInteger);

        List<Thread> list = new ArrayList<>();
        for(int i=0; i<THREAD_COUNT; i++){
            Thread thread = new Thread(runnable);
            list.add(thread);
            thread.start();
        }

        for(Thread thread : list){
            thread.join();
        }

        int result = atomicInteger.get();
        System.out.println("result = " + result);

    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;
        do{
            getValue = atomicInteger.get();
            log("getValue: " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
            log("result:" + result);
        }while(!result);

        return getValue + 1;

    }
}

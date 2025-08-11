package thread.cas.increment;

import java.util.ArrayList;
import java.util.List;

import static thread.util.ThreadUtils.sleep;

public class IncrementPerformanceMain {

    public static final long count = 100_000_000;

    public static void main(String[] args) throws InterruptedException {

        test(new BasicInteger());
        test(new VolatieInteger());
        test(new SyncInteger());
        test(new MyAtomicInteger());

    }

    private static void test(IncrementInteger incrementInteger) throws InterruptedException {
        long startMs = System.currentTimeMillis();

        for(long i=0; i<count; i++){
            incrementInteger.increment();
        }

        long endMs = System.currentTimeMillis();
        System.out.println(incrementInteger.getClass().getSimpleName() + ": ms=" + (endMs-startMs));

    }
}

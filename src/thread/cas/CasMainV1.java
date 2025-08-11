package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasMainV1 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start vlaue = " + atomicInteger.get());

        boolean flag = atomicInteger.compareAndSet(0, 1);
        System.out.println("result1 = " + flag + " value= " +  atomicInteger.get());

        boolean flag2 = atomicInteger.compareAndSet(0, 1);
        System.out.println("result1 = " + flag2 + " value= " +  atomicInteger.get());

    }
}

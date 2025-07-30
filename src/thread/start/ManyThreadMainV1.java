package thread.start;

import thread.util.MyLogger;

import static thread.util.MyLogger.*;

public class ManyThreadMainV1 {

    public static void main(String[] args) {
        log("main() start");

        //same instance hip area
        HelloRunable helloRunable = new HelloRunable();

        Thread thread1 = new Thread(helloRunable);
        thread1.start();

        Thread thread2 = new Thread(helloRunable);
        thread2.start();

        Thread thread3 = new Thread(helloRunable);
        thread3.start();

        log("main() end");








    }
}

package thread.start.test;

import thread.util.MyLogger;

import static thread.util.MyLogger.*;

public class StartTestMain2 {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                log("value:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } , "counter");
        thread.start();

    }


}

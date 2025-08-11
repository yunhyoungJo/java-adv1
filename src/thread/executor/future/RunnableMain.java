package thread.executor.future;

import java.util.Random;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class RunnableMain {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable, "Thread-1");
        thread1.start();
        thread1.join();

        int result = myRunnable.value;
        log("value="+result);


    }

    static class MyRunnable implements Runnable{

        int value;

        @Override
        public void run() {
            log("Runnable 시작");
            sleep(2000);

            value = value + new Random().nextInt(10);
            log("create value=" + value);
            log("Runnable 완료");
        }
    }
}

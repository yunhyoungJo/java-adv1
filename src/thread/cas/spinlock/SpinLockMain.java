package thread.cas.spinlock;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class SpinLockMain {

    public static void main(String[] args) {

        SpinLock spinLockBad = new SpinLock();

        Runnable runnable = ()-> {
            spinLockBad.lock();
            try {
                log("비지니스 로직 실행");
                sleep(1); //오래 걸리는 로직에서는 스핀락사용x
            }finally {
                spinLockBad.unlock();
            }
        };

        Thread thread1 = new Thread(runnable, "thread-1");
        Thread thread2 = new Thread(runnable, "thread-2");

        thread1.start();
        thread2.start();


    }


}

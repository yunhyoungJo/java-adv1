package thread.sync.delete;

import java.util.concurrent.locks.LockSupport;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class LockSupportMainV2 {

    public static void main(String[] args) {
        ParkTest parkTest = new ParkTest();
        Thread thread1 = new Thread(parkTest , "Thread-1");

        thread1.start();
        //잠시 대기하여 park 상태 확인
        sleep(100);
        log("Thread-1 state:" + thread1.getState());
        log("main->unpark");



    }

    static class ParkTest implements Runnable{

        @Override
        public void run() {
            log("park 시작");
            LockSupport.parkNanos(2000_000000); //2초
            log("park 종료 , state: " + Thread.currentThread().getState());
            log("인터럽트 상태 : " + Thread.currentThread().isInterrupted());
        }
    }
}

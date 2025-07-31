package thread.control.interrupt;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class ThreadStopMainV2 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task , "work");
        thread.start();

        log("작업중단지시 interrupt");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1=" + thread.isInterrupted());

    }

    static class MyTask implements Runnable{

        @Override
        public void run() {
            try {
                while(true) {
                    log("작업중");
                    Thread.sleep(3000);
                }
            }catch (InterruptedException e) {
                log("work 스레드 인터럽트 상태2=" + Thread.currentThread().isInterrupted());
                log("interrupt message=" + e.getMessage());
                log("state=" + Thread.currentThread().getState());
            }

            log("자원정리");
            log("자원종료");
        }
    }
}

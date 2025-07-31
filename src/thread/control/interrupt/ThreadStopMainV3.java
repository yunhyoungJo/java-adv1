package thread.control.interrupt;

import static thread.util.MyLogger.log;

public class ThreadStopMainV3 {

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread thread = new Thread(task , "work");
        thread.start();

        Thread.sleep(100);
        log("작업중단지시 interrupt");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1=" + thread.isInterrupted());

    }

    static class MyTask implements Runnable{

        @Override
        public void run() {

            while(!Thread.currentThread().isInterrupted()) {
                log("작업중");
            }
            //상태변경x
            log("work 스레드 인터럽트 상태2=" + Thread.currentThread().isInterrupted());
            log("work 스레드 인터럽트 상태2=" + Thread.currentThread().getState());


            try {
                log("자원정리");
                Thread.sleep(1000);
                log("자원정리중"); //실패
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3=" + Thread.currentThread().isInterrupted());
            }
            log("작업종료");

        }
    }
}

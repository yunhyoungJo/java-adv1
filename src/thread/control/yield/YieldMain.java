package thread.control.yield;

import thread.start.HelloRunable;

import static thread.util.ThreadUtils.sleep;

public class YieldMain {

    static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
       for(int i=0; i<THREAD_COUNT; i++){
            Thread thread = new Thread(new MyTask());
            thread.start();
        }
        //int threadCount = Thread.activeCount();
        //System.out.println("현재 실행 중인 스레드 수: " + threadCount);
    }

    static class MyTask implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                //1.empty
                System.out.println(Thread.currentThread().getName() + ":" + i);

                //2.sleep(1);
                //sleep(1000);

                //3.Thread.yield();
                //Thread.yield(); //runnable상태
            }
        }
    }
}

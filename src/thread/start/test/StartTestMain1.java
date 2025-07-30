package thread.start.test;

import thread.util.MyLogger;

public class StartTestMain1 {

    public static void main(String[] args) {

        CounterThread counterThread = new CounterThread();
        CounterThread2 counterThread2 = new CounterThread2();
        counterThread.start();
        counterThread2.start();

    }

    static class CounterThread extends Thread{
        @Override
        public void run() {
            for(int i=0; i<5000; i++){
                MyLogger.log("value:"+i);
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
            }
        }
    }

    static class CounterThread2 extends Thread{
        @Override
        public void run() {
            for(int i=0; i<5000; i++){
                MyLogger.log("value::::::::::::::::::::::::"+i);
               /* try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
            }
        }
    }
}

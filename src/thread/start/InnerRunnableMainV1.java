package thread.start;

import thread.util.MyLogger;

import static thread.util.MyLogger.*;

public class InnerRunnableMainV1 {

    public static void main(String[] args) {
        log("main() start");

        InnterRunable runable = new InnterRunable();
        Thread thread = new Thread(runable);
        thread.start();

        log("main() end");
    }

    //정접 중첩 클래스
    static public class InnterRunable implements Runnable{
        @Override
        public void run() {
            log(": run()");
        }
    }


}

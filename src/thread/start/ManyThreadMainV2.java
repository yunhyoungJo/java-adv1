package thread.start;

import static thread.util.MyLogger.log;

public class ManyThreadMainV2 {

    public static void main(String[] args) {
        log("main() start");

        //same instance hip area
        HelloRunable runable = new HelloRunable();

        for(int i=0; i<100; i++){
            Thread thread = new Thread(runable);
            thread.start();
        }
        log("main() end");

    }
}

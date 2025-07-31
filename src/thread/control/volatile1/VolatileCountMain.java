package thread.control.volatile1;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread t = new Thread(myTask , "work");
        t.start();

        sleep(1000);

        myTask.flag = false;

        log("flag : " + myTask.flag + ", count : " + myTask.count + " 종료");

    }

    static class MyTask implements Runnable{

        //boolean flag = true;
        //long count;

        volatile boolean flag = true;
        volatile long count;


        @Override
        public void run() {
            while (flag){
                count++;
                if(count % 100_000_000 == 0){
                    log("flag : " + flag + ", count : " + count + " in while()"); //컨텍스트 스위칭 가능성
                }
            }

            log("flag : " + flag + ", count : " + count + " 종료");
        }
    }
}

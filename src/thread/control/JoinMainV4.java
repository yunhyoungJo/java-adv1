package thread.control;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class JoinMainV4 {

    public static void main(String[] args) throws InterruptedException {
        log("start");
        SumTask task1 = new SumTask(1,50);
        Thread thread1 = new Thread(task1 , "thread-1");

        thread1.start();
        thread1.join(1000);

        log("task1.result= " + task1.result);
        log("end");

    }


    static class SumTask implements Runnable{

        int startValue;
        int endValue;
        int result;

        public SumTask(int startValue, int endValue) {

            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업시작");
            sleep(2000);
            log("작업완료");

            int sum = 0;
            for(int i=startValue; i<=endValue; i++){
                sum +=i;
            }
            result = sum;
            log("작업완료 result = " + result);
        }

    }
}

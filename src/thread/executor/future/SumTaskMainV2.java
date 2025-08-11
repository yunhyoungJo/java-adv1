package thread.executor.future;

import java.util.concurrent.*;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class SumTaskMainV2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        log("start");
        SumTask sumTask1 = new SumTask(0, 50);
        SumTask sumTask2 = new SumTask(51, 100);

        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = es.submit(sumTask1); //non-blocking
        Future<Integer> future2 = es.submit(sumTask2);

        //blocking
        Integer sum1 = future1.get();
        Integer sum2 = future2.get();

        int sumAll = sum1 + sum2;
        log("result:" + sumAll);

        log("end");

        es.close();
    }

    static class SumTask implements Callable<Integer> {

        int startValue;
        int endValue;


        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws InterruptedException {
            log("작업시작");
            Thread.sleep(2000);
            log("작업완료");

            int sum = 0;
            for(int i=startValue; i<=endValue; i++){
                sum +=i;
            }
            log("작업완료 result = " + sum);
            return sum;
        }

    }
}

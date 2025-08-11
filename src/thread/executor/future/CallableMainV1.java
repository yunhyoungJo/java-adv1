package thread.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class CallableMainV1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> future = es.submit(new MyCallable());
        Future<Integer> future2 = es.submit(new MyCallable());
        log("result future = " + future);
        log("result future2 = " + future2);
        Integer result1 = future.get();
        Integer result2 = future.get();

        log("result vlaue = " + future);
        es.close();


    }

    static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {

            log("Callable 시작");
            sleep(10000);
            log("Callable 완료");
            return new Random().nextInt(10);
        }
    }
}

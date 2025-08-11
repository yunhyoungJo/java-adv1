package thread.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class CallableMainV2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(2);
        log("submit() 호출");
        Future<Integer> future = es.submit(new MyCallable());
        Future<Integer> future2 = es.submit(new MyCallable());
        log("result future = " + future);
        log("result future2 = " + future2);

        log("future.get() 블로킹 메서드 호출 시작 -> main.waiting");
        Integer result1 = future.get();
        Integer result2 = future.get();
        log("future.get() 블로킹 메서드 호출 완료 -> main.runnable");

        log("future완료 = " + future);
        es.close();
    }

    static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            log("Callable 시작");
            sleep(1000);
            log("Callable 완료");
            return new Random().nextInt(10);
        }
    }
}

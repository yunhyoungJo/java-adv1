package thread.executor.future;

import java.util.concurrent.*;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class FetureExceptionMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("작업전달");
        Future<Integer> future = es.submit(new ExCallable());
        sleep(1000);

        try {
            log("future.get() 호출시도 , future.state():" + future.state());
            Integer result = future.get();
            log("result:" + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            log("실행 중 예외발생");
            Throwable cause = e.getCause();
            log("원인:"+cause);
        }finally {
            es.close();
        }


    }

    static class ExCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            log("Callable 실행, 예외 발생");
            throw new IllegalStateException("ex!");
        }
    }
}

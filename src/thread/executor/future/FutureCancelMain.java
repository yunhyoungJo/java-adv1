package thread.executor.future;

import java.util.concurrent.*;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class FutureCancelMain {

    //private static boolean mayInterrputIfRunning = true;
    private static boolean mayInterrputIfRunning = false; //실행중인건 취소x

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> future = es.submit(new MyTask());
        log("Future.state:" + future.state());

        sleep(3000);
        log("cancel 호출:"+ mayInterrputIfRunning);
        boolean cancel = future.cancel(mayInterrputIfRunning);
        log("Future.state:" + future.state());
        log("cancel("+mayInterrputIfRunning+") result:" + cancel);

        //결과 확인
        try {
            log("Feture.result:"+ future.get());
        }catch(CancellationException e) {
            log("Future가 이미 취소 되었습니다.");
        }catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        es.close();

    }

    static class MyTask implements Callable<String>{

        @Override
        public String call() throws Exception {
            try {
                for (int i = 0; i < 10; i++) {
                    log("작업중:" + i);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                log("인터럽트 발생");
                return "Interrupted";
                //throw new RuntimeException(e);
            }
            return "Completed";
        }
    }
}

package thread.executor.reject;

import thread.executor.RunnableTask;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static thread.util.MyLogger.log;

public class RejectMainV4 {

    public static void main(String[] args) {
        ThreadPoolExecutor es = new ThreadPoolExecutor(1,
                1,
                0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                //new ThreadPoolExecutor.AbortPolicy()); //예외 RejectedExecutionException
                //new ThreadPoolExecutor.DiscardPolicy()); //예외 버림
                //new ThreadPoolExecutor.CallerRunsPolicy() ); //생산이 소비까지 함으로써 생산속도 조절
                new MyRejectedExecutionHandler());


        es.submit(new RunnableTask("task1"));
        try {
            es.submit(new RunnableTask("task2"));
        }catch (RejectedExecutionException e){
            log("요청 초과");
            //포기 , 다시 시도 등
            log(e);
        }
        es.submit(new RunnableTask("task3"));
        es.submit(new RunnableTask("task4"));
        es.close();

    }

    static class MyRejectedExecutionHandler implements RejectedExecutionHandler{

        static AtomicInteger count = new AtomicInteger(0);

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            int i = count.incrementAndGet();
            log("[경고]거절된 작업의 수:"+i);
        }
    }
}

package thread.executor.reject;

import thread.executor.RunnableTask;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static thread.util.MyLogger.log;

public class RejectMainV1 {

    public static void main(String[] args) {
        ThreadPoolExecutor es = new ThreadPoolExecutor(1,
                1,
                0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>() ,
                //new ThreadPoolExecutor.AbortPolicy()); //예외 RejectedExecutionException
                //new ThreadPoolExecutor.DiscardPolicy()); //예외 버림
                new ThreadPoolExecutor.CallerRunsPolicy() ); //생산이 소비까지 함으로써 생산속도 조절

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
}

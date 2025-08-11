package thread.executor.poolsize;

import thread.executor.ExecutorUtils;
import thread.executor.RunnableTask;
import thread.util.MyLogger;
import thread.util.ThreadUtils;

import java.util.concurrent.*;

import static thread.executor.ExecutorUtils.*;
import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class PoolSizeMainV1 {

    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);

        ExecutorService es =
                new ThreadPoolExecutor(2, 4, 3000, TimeUnit.MILLISECONDS, workQueue);

        printState(es);

        es.execute(new RunnableTask("task1"));
        printState(es , "task1");

        es.execute(new RunnableTask("task2"));
        printState(es , "task2");

        es.execute(new RunnableTask("task3"));
        printState(es , "task3");

        es.execute(new RunnableTask("task4"));
        printState(es , "task4");

        es.execute(new RunnableTask("task5"));
        printState(es , "task5");

        es.execute(new RunnableTask("task6"));
        printState(es , "task6");

        try{
            es.execute(new RunnableTask("task7"));
        }catch (RejectedExecutionException e){
            log("task7 실행거절 예외:"+e);
        }

        sleep(3000);
        log("==작업 실행 완료==");
        printState(es);

        sleep(3000);
        log("== maxinum 대기시간 초과===");
        printState(es);

        es.close();
        log("==== shutdown 완료=====");
        printState(es);



    }
}

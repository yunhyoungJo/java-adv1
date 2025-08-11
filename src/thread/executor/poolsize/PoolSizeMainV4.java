package thread.executor.poolsize;

import thread.executor.RunnableTask;

import java.util.concurrent.*;

import static thread.executor.ExecutorUtils.printState;
import static thread.util.MyLogger.log;

public class PoolSizeMainV4 {

    //static final int TASK_SIZE = 1100; //1.일반
    static final int TASK_SIZE = 1200; //2.긴급
    //static final int TASK_SIZE = 1300; //3.거절

    public static void main(String[] args) {

        ExecutorService es = new ThreadPoolExecutor(100,
                200,
                60, TimeUnit.SECONDS ,
                new ArrayBlockingQueue<>(1000));


        printState(es);

        long startMs = System.currentTimeMillis();

        for (int i = 0; i <= TASK_SIZE; i++) {
            String taskName = "task" + i;
            try{
                es.execute(new RunnableTask(taskName));
                printState(es,taskName);
            }catch (RejectedExecutionException e){
                log(taskName + " ->" + e);
                printState(es);
            }
        }
        
        
        es.close();
        
        long endMs = System.currentTimeMillis();

        long result = endMs - startMs;

        log("===shutdown완료===:"+result);



    }
}

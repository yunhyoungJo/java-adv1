package thread.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static thread.util.MyLogger.log;

public abstract class ExecutorUtils {

    public static void printState(ExecutorService executorService){
        if(executorService instanceof ThreadPoolExecutor poolExecutor){
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queued = poolExecutor.getQueue().size();
            long completedTask = poolExecutor.getCompletedTaskCount(); //완료작업

            log("[pool=" + pool +
                    " , active=" +  active +
                    " , queuedTasks=" + queued +
                    " , completedTask=" + completedTask + "]");
        }else{
            log(executorService);
        }
    }

    public static void printState(ExecutorService executorService , String task){
        if(executorService instanceof ThreadPoolExecutor poolExecutor){
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queued = poolExecutor.getQueue().size();
            long completedTask = poolExecutor.getCompletedTaskCount(); //완료작업

            log(task+" -> [pool=" + pool +
                    " , active=" +  active +
                    " , queuedTasks=" + queued +
                    " , completedTask=" + completedTask + "]");
        }else{
            log(executorService);
        }
    }
}

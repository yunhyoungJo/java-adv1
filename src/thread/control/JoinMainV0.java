package thread.control;

import thread.util.MyLogger;
import thread.util.ThreadUtils;

import javax.management.relation.RelationNotFoundException;

import static thread.util.MyLogger.*;
import static thread.util.ThreadUtils.*;

public class JoinMainV0 {

    public static void main(String[] args) {
        log("start");
        Thread thread1 = new Thread(new Job(), "thread-1");
        Thread thread2 = new Thread(new Job(), "thread-2");

        thread1.start();
        thread2.start();

        log("end");
    }

    static class Job implements Runnable{

        @Override
        public void run() {
            log("작업시작");
            sleep(2000);
            log("작업 완료");
        }
    }
}

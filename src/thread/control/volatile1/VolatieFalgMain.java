package thread.control.volatile1;

import javax.management.relation.RelationNotFoundException;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class VolatieFalgMain {

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread thread = new Thread(task , "work");
        log("runFlag = " + task.runFlag);
        thread.start();

        sleep(1000);
        task.runFlag = false;

        log("runFlag = " + task.runFlag);
        log("main 종료");

    }

    static class MyTask implements Runnable{

        boolean runFlag = true;
        //캐쉬메모리 사용안하고 메인메모리 직접 접근 성능↓
        //메모리 가시성
        //volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");
            while(runFlag){
                //runFlag가 false로 변해도 exit 못함 캐쉬메모리에 저장
                System.out.println("test"); //컨텍스트 스위칭되면서 flag변경 하지만 절대 보장은 아님
            }
            log("task 종료");
        }
    }
}

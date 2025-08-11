package thread.cas.spinlock;

import java.util.concurrent.atomic.AtomicBoolean;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class SpinLockBad {

    private volatile boolean lock = false;

    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public void lock(){
        log("락 획득 시도");

        while(true){
            if(!lock){ // 1.락여부 false
                sleep(100); //스레드 대기 문제 상황 확인
                lock = true; //2.락의 값 변경
                break;
            }else{
                //락 획득할떄까지 대기
                log("락 획득 실패 - 스핀대기");
            }
        }
        log("락 획득 완료");
    }

    public void unlock(){
        lock = false;
        log("락 반납 완료");
    }

}

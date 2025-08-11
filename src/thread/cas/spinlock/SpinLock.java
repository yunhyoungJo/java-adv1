package thread.cas.spinlock;

import java.util.concurrent.atomic.AtomicBoolean;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class SpinLock {

    
    private AtomicBoolean lock = new AtomicBoolean(false);

    public void lock(){
        log("락 획득 시도");

        while(!lock.compareAndSet(false , true)){
            log("락 획득 실패 - 스핀대기");
        }

        log("락 획득 완료");
    }

    public void unlock(){
        lock.set(false);
        log("락 반납 완료");
    }

}

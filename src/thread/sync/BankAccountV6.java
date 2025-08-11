package thread.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class BankAccountV6 implements BankAccount {

    private int balance;  //volatile 캐쉬메모리 -> 메모리 synchronized시 안해도됨

    private final Lock lock = new ReentrantLock();

    public BankAccountV6(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {

        log("거래시작: " + getClass().getSimpleName());


        try {
            if(!lock.tryLock(500, TimeUnit.MILLISECONDS)){
                log("진입실패: 이미 처리중인 작업이 있습니다.");
                return false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //lock.lock(); // ReentrantLock 이용 lock

        try{

            log("[검증 시작]출금액:" + amount + ", 잔액: " + balance);

            if (balance < amount) { //임계영역
                log("[검증 실패]출금액:" + amount + ", 잔액: " + balance);
                return false;
            }

            //잔고가 출금액 보다 많으면 true
            log("[검증 완료]출금액:" + amount + ", 잔액: " + balance);
            sleep(1000);
            balance = balance - amount; //임계영역
            log("[출금 완료]출금액:" + amount + ", 잔액: " + balance);

        }finally {
            lock.unlock(); //반드시 락 해제
        }


        log("거래 종료");
        return true;
    }

    @Override
    public  int getBalance() {
        lock.lock();
        try{
            return balance;
        }finally {
            lock.unlock(); //반드시 락 해제
        }
    }
}

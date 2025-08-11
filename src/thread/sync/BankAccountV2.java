package thread.sync;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class BankAccountV2 implements BankAccount{

    private int balance;  //volatile 캐쉬메모리 -> 메모리 synchronized시 안해도됨

    public BankAccountV2(int balance) {
        this.balance = balance;
    }

    @Override
    public synchronized boolean withdraw(int amount) {

        log("거래시작: " + getClass().getSimpleName());

        //잔고가 출금액 보다 적으면 false
        log("[검증 시작]출금액:" + amount + ", 잔액: " + balance);
        if( balance < amount){ //임계영역
            log("[검증 실패]출금액:" + amount + ", 잔액: " + balance);
            return false;
        }

        //잔고가 출금액 보다 많으면 true
        log("[검증 완료]출금액:" + amount + ", 잔액: " + balance);
        sleep(1000);
        balance = balance - amount; //임계영역
        log("[출금 완료]출금액:" + amount + ", 잔액: " + balance);

        log("거래 종료");
        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}

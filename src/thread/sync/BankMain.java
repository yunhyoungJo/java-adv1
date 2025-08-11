package thread.sync;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {
        //BankAccount bankAccount = new BankAccountV1(1000);
        //BankAccount bankAccount = new BankAccountV2(1000);
        //BankAccount bankAccount = new BankAccountV3(1000);
        //BankAccount bankAccount = new BankAccountV4(1000);
        //BankAccount bankAccount = new BankAccountV5(1000);
        BankAccount bankAccount = new BankAccountV6(1000);

        Thread t1 = new Thread(new WithdrawTask(bankAccount, 800) , "t1");
        Thread t2 = new Thread(new WithdrawTask(bankAccount, 800) , "t2");

        t1.start();
        t2.start();

        sleep(500); //검증 완료까지 대기
        log("t1 state:" + t1.getState()); //TIMED_WAITING
        log("t2 state:" + t2.getState()); //BLOCKED

        t1.join();
        t2.join();

        log("최종 잔액:" + bankAccount.getBalance());

    }
}

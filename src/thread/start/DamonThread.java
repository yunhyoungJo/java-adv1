package thread.start;

public class DamonThread {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + ": main start");

        DaemonThread daemonThread = new DaemonThread();

        daemonThread.setDaemon(true); //데몬 스레드 여부 기본값 false
        daemonThread.start();

        System.out.println(Thread.currentThread().getName() + ": main end");

        //사용자 thread 종료시 데몬 스레드 종료
    }

    static class DaemonThread extends Thread{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run()");
            try {
                Thread.sleep(10000); //10초간 실행
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": run() end");
        }
    }
}

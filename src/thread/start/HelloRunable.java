package thread.start;

public class HelloRunable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": run()");
    }
}

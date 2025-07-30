package thread.start;

public class BadThread {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 전");
        helloThread.start();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 후 1");
        System.out.println(Thread.currentThread().getName() + ": start() 호출 후 2");

        System.out.println(thread.getName() + ": main() end");

    }
}

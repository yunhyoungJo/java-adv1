package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 전");
        //helloThread.start();
        helloThread.run(); //직접 실행
        System.out.println(Thread.currentThread().getName() + ": start() 호출 후 1");
        System.out.println(Thread.currentThread().getName() + ": start() 호출 후 2");

        System.out.println(thread.getName() + ": main() end");

    }
}

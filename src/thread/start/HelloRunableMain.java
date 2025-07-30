package thread.start;

public class HelloRunableMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        //HelloRunable helloRunable = new HelloRunable();
        Thread thread = new Thread(()-> System.out.println(Thread.currentThread().getName() + ": run()"));
        thread.start();
        System.out.println(Thread.currentThread().getName() + ": main() end");

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}

package thread.start.test;

import com.sun.source.tree.WhileLoopTree;

import static thread.util.MyLogger.log;

public class StartTestMain4 {

    public static void main(String[] args) {

        PrintWork printWorkA = new PrintWork("A", 1000);
        PrintWork printWorkB = new PrintWork("B" , 500);

        Thread threadA = new Thread(printWorkA , "Thread-A");
        Thread threadB = new Thread(printWorkB , "Thread-B");

        threadA.start();
        threadB.start();

    }

    static class PrintWork implements Runnable{

        private String content;
        private int sleeMs;

        public PrintWork(String content, int sleeMs) {
            this.content = content;
            this.sleeMs = sleeMs;
        }

        @Override
        public void run() {

            while(true){
                log(content);
                try {
                    Thread.sleep(sleeMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}

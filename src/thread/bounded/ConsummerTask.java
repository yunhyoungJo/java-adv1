package thread.bounded;

import java.util.concurrent.BlockingQueue;

import static thread.util.MyLogger.log;

public class ConsummerTask implements Runnable{

    private BlockingQueue<String> queue;

    public ConsummerTask(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log("[소비 시도]     ? <- " + queue);
        try {
            String data = queue.take();
            log("[소비 완료]" + data + " <- " + queue);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

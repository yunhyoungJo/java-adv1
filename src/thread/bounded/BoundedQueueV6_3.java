package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static thread.util.MyLogger.log;

public class BoundedQueueV6_3 implements BoundedQueue{

    private BlockingQueue<String> queue;

    public BoundedQueueV6_3(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {

        try {
            boolean offer = queue.offer(data, 1, TimeUnit.MILLISECONDS);
            log("저장 시도 결과:" + offer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String take() {

        try {
            String poll = queue.poll(2, TimeUnit.SECONDS);
            log("소비 시도 결과:" + poll);
            return poll;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String toString() {
        return queue.toString();
    }
}

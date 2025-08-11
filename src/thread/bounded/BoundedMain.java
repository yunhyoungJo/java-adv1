package thread.bounded;

import java.util.ArrayList;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class BoundedMain {

    public static void main(String[] args) {

        //BoundedQueue queue = new BoundedQueueV1(2);
        //BoundedQueue queue = new BoundedQueueV2(2);
        //BoundedQueue queue = new BoundedQueueV3(2);
        //BoundedQueue queue = new BoundedQueueV4(2);
        //BoundedQueue queue = new BoundedQueueV5(2);
        BoundedQueue queue = new BoundedQueueV6_4(3);

        //생산자 소비자 실행 순서 선택 , 반드시 하나만 선택
        //producerFist(queue); //생산자 먼저 실행
        comsummerFist(queue);  //소비자 먼저 실행

    }

    private static void comsummerFist(BoundedQueue queue) {
        log("== [소비자 먼저 실행] 시작, " + queue.getClass().getSimpleName() + " ==");
        ArrayList<Thread> threads = new ArrayList<>();
        startConsumer(queue , threads);
        printAllState(queue, threads);
        startProducer(queue , threads);
        printAllState(queue, threads);
        log("== [소비자 먼저 실행] 종료, " + queue.getClass().getSimpleName() + " ==");
    }

    private static void producerFist(BoundedQueue queue) {
        log("== [생산자 먼저 실행] 시작, " + queue.getClass().getSimpleName() + " ==");
        ArrayList<Thread> threads = new ArrayList<>();
        startProducer(queue , threads); //생산자
        printAllState(queue, threads); //상태출력
        startConsumer(queue , threads);
        printAllState(queue, threads);
        log("== [생산자 먼저 실행] 종료, " + queue.getClass().getSimpleName() + " ==");
    }


    private static void startProducer(BoundedQueue queue, ArrayList<Thread> threads) {
        System.out.println();
        log("obj 생산자 시작");
        for(int i=1; i<=3; i++){
            Thread producer = new Thread(new ProducerTask(null , "data" + i) , "producer"+i);
            threads.add(producer);
            producer.start();
            sleep(100);
        }
    }

    private static void printAllState(BoundedQueue queue, ArrayList<Thread> threads) {
        System.out.println();
        log("현재 상태 출력, 큐 데이터: "+ queue);

        for(Thread thread : threads){
            log(thread.getName() + " : " + thread.getState());
        }
    }

    private static void startConsumer(BoundedQueue queue, ArrayList<Thread> threads) {
        System.out.println();
        log("obj 소비자 시작");
        for(int i=1; i<=3; i++){
            Thread consummer = new Thread(new ConsummerTask(null) , "consumer"+i);
            threads.add(consummer);
            consummer.start();
            sleep(100);
        }
    }
}

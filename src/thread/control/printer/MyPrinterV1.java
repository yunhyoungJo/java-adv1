package thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class MyPrinterV1 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread thread = new Thread(printer, "printer");
        thread.start();

        Scanner scanner = new Scanner(System.in);
        while(true){
            log("프린터할 문서를 입력하세요. 종료(q):");
            String input = scanner.nextLine();
            if(input.equals("q")){
                printer.work = false;
                break;
            }
            printer.add(input);
        }

    }

    static class Printer implements Runnable{

        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {

            while(work){
                if(jobQueue.isEmpty()){
                    continue;
                }

                String job = jobQueue.poll();
                log("출력시작: " + job + " / 대기 문서: " + jobQueue);
                sleep(3000);
                log("출력 완료");
            }

            log("출력완료");
        }

        public void add(String input){
            boolean offer = jobQueue.offer(input);
        }
    }
}

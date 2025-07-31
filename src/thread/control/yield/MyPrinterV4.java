package thread.control.yield;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static thread.util.MyLogger.log;

public class MyPrinterV4 {

    public static void main(String[] args) {

        Printer printer = new Printer();
        Thread thread = new Thread(printer, "printer");
        thread.start();

        Scanner scanner = new Scanner(System.in);
        while(true){
            log("프린터할 문서를 입력하세요. 종료(q):");
            String input = scanner.nextLine();
            if(input.equals("q")){
                thread.interrupt();
                break;
            }
            printer.add(input);
        }

    }

    static class Printer implements Runnable{

        //volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {

            while(!Thread.interrupted()){ //인터럽트 상태 변경
                if(jobQueue.isEmpty()){
                    Thread.yield(); //추가 양보 없으면 while문 계속 반복 cpu비효율적
                    continue;
                }

                try {
                    String job = jobQueue.poll();
                    log("출력시작: " + job + " / 대기 문서: " + jobQueue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log("인터럽트");
                    break;
                }
            }
            log("프린터 종료");

        }

        public void add(String input){
            boolean offer = jobQueue.offer(input);
        }
    }
}

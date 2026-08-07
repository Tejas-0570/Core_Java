/*
Two threads — odd and even printer

Create two threads — one prints odd numbers 1 to 10, another prints even numbers 2 to 10. Run both simultaneously.
First using Thread class (extend), then using Runnable interface (implement). Observe how output order differs each run.

Thread-1 (odd): 1 3 5 7 9
Thread-2 (even):2 4 6 8 10
output order varies each run — shows concurrent execution

Skills: extends Thread, implements Runnable, start() vs run(), Thread.sleep(), concurrency observation

 */

public class TwoThreadsOddAndEvenPrinter {
    public static void main(String[] args) {
        new OddPrinter().start();
        new Thread(new EvenPrinter()).start();
    }
}

class EvenPrinter  implements Runnable{
    public void run(){
        for(int i = 1; i <= 10; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class OddPrinter  extends Thread{
    public void run(){
        for(int i = 1; i <= 10; i++){
            if(i % 2 != 0){
                System.out.println(i);
            }
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
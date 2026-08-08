/*
Race condition — shared counter

Create a Counter class with increment(). Launch 5 threads each calling increment() 1000 times — expected total is 5000.
 First run WITHOUT synchronized and observe wrong answer. Then add synchronized and observe correct 5000.
 Understand why the race condition happens.

Without sync: total = 4768 (different every run — race condition)
With sync: total = 5000 (always correct — thread safe)

Skills: race condition, synchronized method, join(), thread safety, why count++ is not atomic

 */

public class RaceConditionSharedCounter {
    static final int THREAD_COUNT = 5;
    static final int INCREMENT_PER_THREAD = 1000;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("---------------- Without Synchronization -----------------------");
        Counter unsafeCounter = new Counter(false);
        runIncrement(unsafeCounter);
        System.out.println("Expected: "+(THREAD_COUNT * INCREMENT_PER_THREAD));
        System.out.println("Actual: "+unsafeCounter.getCnt());

        System.out.println("---------------- With Synchronization -----------------------");
        Counter safeCounter = new Counter(true);
        runIncrement(safeCounter);
        System.out.println("Expected: "+(THREAD_COUNT * INCREMENT_PER_THREAD));
        System.out.println("Actual: "+safeCounter.getCnt());

    }

    static void runIncrement(Counter counter) throws InterruptedException{
        Thread[] threads = new Thread[THREAD_COUNT];

        for(int i = 0; i < THREAD_COUNT; i++){
            threads[i] = new Thread(new IncrementTask(counter));
            threads[i].start();
        }

        for(Thread t : threads ){
            t.join();
        }
    }
}

class IncrementTask implements Runnable {
    private Counter counter;
    IncrementTask(Counter counter){
        this.counter = counter;
    }
    public void run(){
        for(int i = 0; i < RaceConditionSharedCounter.INCREMENT_PER_THREAD; i++){
            counter.increment();
        }
    }
}

class Counter{
    private int cnt = 0;
    boolean useSync;

    Counter(boolean useSync){
        this.useSync = useSync;
    }

    public void increment(){
        if(useSync){
            incrementSafe();
        } else {
            incrementUnsafe();
        }
    }

    private synchronized void incrementSafe(){
        cnt++;
    }

    private void incrementUnsafe(){
        cnt++;
    }

    public int getCnt(){
        return cnt;
    }
}

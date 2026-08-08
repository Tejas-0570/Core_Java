/*
Multithreaded bank with deadlock demonstration

Create two BankAccount objects. Thread 1 transfers from A to B. Thread 2 transfers from B to A simultaneously.
First show the deadlock happening (both threads freeze). Then fix it using consistent lock ordering — always
lock the lower account id first.

Without fix: Thread-1 locks A, waits for B
Thread-2 locks B, waits for A → deadlock — program hangs
With fix: both threads lock in same order → no deadlock, completes

Skills: deadlock, circular wait, synchronized block, lock ordering fix, nested synchronized

 */
public class MultiThreadedBank {
    public static void main(String[] args) {
        int out = 5;
        System.out.println(out);
    }
}

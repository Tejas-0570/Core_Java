/*
#5 Medium Vector in multi-class design
-----------------------------------------------------------------------------------------------------------------------------------
Thread-safe exam result publisher

ResultPublisher class holds a Vector of results. Three student threads simultaneously try to read results while one teacher thread is
writing results. Show that Vector allows safe concurrent reads and writes without explicit synchronization code. Then rewrite using
Collections.synchronizedList() wrapping an ArrayList to show the modern equivalent.
-----------------------------------------------------------------------------------------------------------------------------------
⚠️ Legacy approach — Vector: Vector handles thread safety internally — no synchronized keyword needed in your code. Simple to use but
inflexible — you cannot choose WHICH operations to synchronize. Compound operations like "check if exists then add" are still not atomic
even with Vector — two synchronized calls is not the same as one atomic operation.
-----------------------------------------------------------------------------------------------------------------------------------
✅ Modern replacement — Collections.synchronizedList(): List<String> safeList = Collections.synchronizedList(new ArrayList<>()).
Wraps any List with synchronization on demand. For compound operations, manually synchronize the block:
synchronized(safeList) { if(!safeList.contains(x)) safeList.add(x); } — gives you explicit control Vector never had.
-----------------------------------------------------------------------------------------------------------------------------------
Teacher thread: adds results every 200ms
Student threads: read results simultaneously
Vector result: no corruption — built-in sync
SynchronizedList:same safety + explicit control

Skills: shared Vector across threads, compound operation atomicity problem, Collections.synchronizedList(), synchronized block
Hint at bottom --->
 */

package Vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ThreadSafeExamResultPublisher {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("=========== PART 1: Vector (built-in synchronization) ===========");
        runVectorDemo();

        System.out.println("\n=========== PART 2: Collections.synchronizedList() ===========");
        runSynchronizedListDemo();
    }

    // ---------------------------------------------------------------
    // PART 1 — Vector
    // ---------------------------------------------------------------
    static void runVectorDemo() throws InterruptedException {
        Vector<String> results = new Vector<>();

        Runnable teacher = () -> {
            for (int i = 1; i <= 3; i++) {
                results.add("Result" + i);
                System.out.println("[Vector] Teacher added Result" + i);
                sleep(200);
            }
        };

        Runnable student = () -> {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 5; i++) {
                System.out.println("[Vector] " + name + " sees size: " + results.size() + " | " + results);
                sleep(100);
            }
        };

        Thread t1 = new Thread(teacher, "Teacher");
        Thread t2 = new Thread(student, "Student1");
        Thread t3 = new Thread(student, "Student2");
        Thread t4 = new Thread(student, "Student3");

        t1.start(); t2.start(); t3.start(); t4.start();
        t1.join(); t2.join(); t3.join(); t4.join();

        System.out.println("[Vector] Final results: " + results);

        // --- Compound operation problem — NOT atomic, even on Vector ---
        // Both contains() and add() are individually synchronized, but the GAP between
        // them is not protected. Two threads can both pass the contains() check before
        // either calls add(), producing a duplicate entry:
        //
        // if(!results.contains("ResultX")) {   // thread A checks: false (not present)
        //                                       // thread B checks: false (not present) <- both pass!
        //     results.add("ResultX");          // both threads add it -> duplicate
        // }
        System.out.println("[Vector] Compound check-then-add is NOT atomic — see comment above.");
    }

    // ---------------------------------------------------------------
    // PART 2 — Collections.synchronizedList()
    // ---------------------------------------------------------------
    static void runSynchronizedListDemo() throws InterruptedException {
        List<String> safeResults = Collections.synchronizedList(new ArrayList<>());

        Runnable teacher = () -> {
            for (int i = 1; i <= 3; i++) {
                safeResults.add("Result" + i);
                System.out.println("[SyncList] Teacher added Result" + i);
                sleep(200);
            }
        };

        Runnable student = () -> {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 5; i++) {
                // reading size()/toString() is safe individually, same as Vector
                System.out.println("[SyncList] " + name + " sees size: " + safeResults.size() + " | " + safeResults);
                sleep(100);
            }
        };

        Thread t1 = new Thread(teacher, "Teacher");
        Thread t2 = new Thread(student, "Student1");
        Thread t3 = new Thread(student, "Student2");
        Thread t4 = new Thread(student, "Student3");

        t1.start(); t2.start(); t3.start(); t4.start();
        t1.join(); t2.join(); t3.join(); t4.join();

        System.out.println("[SyncList] Final results: " + safeResults);

        // --- Fixing the compound operation problem — THIS is what Vector cannot give you ---
        // Wrapping the check AND the add inside one synchronized block, using the list itself
        // as the lock, makes the whole sequence a single atomic unit. No other thread can
        // acquire the lock and slip an add() in between the check and the add.
        synchronized (safeResults) {
            if (!safeResults.contains("ResultX")) {
                safeResults.add("ResultX");
                System.out.println("[SyncList] Added ResultX inside synchronized block — atomic, safe from duplication");
            } else {
                System.out.println("[SyncList] ResultX already present — skipped");
            }
        }

        System.out.println("[SyncList] Final results after atomic compound op: " + safeResults);
    }

    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/*
Vector implementation:
Vector<String> results = new Vector<>() — shared between threads.
Teacher Runnable: loop adding "Result-"+i with Thread.sleep(200).
Student Runnable: loop reading results.size() and results.toString() with Thread.sleep(100).
Start teacher thread and 3 student threads. No synchronized keyword needed anywhere — Vector handles it. t.join() all threads before printing final results.

Compound operation problem to demonstrate:
if(!results.contains("ResultX")) { results.add("ResultX"); }
— contains() is synchronized, add() is synchronized — but between the two calls another thread can add "ResultX". Not atomic. Show this in a comment.

Modern Collections.synchronizedList():
List<String> results = Collections.synchronizedList(new ArrayList<>())
Same thread code works identically. For compound operations wrap in synchronized block:
synchronized(results) { if(!results.contains("ResultX")) results.add("ResultX"); }
This makes the compound check-then-add atomic — something Vector cannot guarantee.
 */
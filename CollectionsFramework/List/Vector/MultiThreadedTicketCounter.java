/*
#2 Medium Thread safety proof
-----------------------------------------------------------------------------------------------------------------------------------
Multi-threaded ticket counter

Two threads simultaneously add 1000 tickets each to a shared list — total expected: 2000. Run with ArrayList first — show data corruption
(total less than 2000). Run with Vector — show correct result always. This directly proves Vector's only real advantage over ArrayList.
-----------------------------------------------------------------------------------------------------------------------------------
⚠️ Legacy approach — Vector: Vector's synchronization guarantees every add() completes atomically — no two threads modify the list
simultaneously. Result is always exactly 2000. But this synchronization happens on EVERY method call including reads — even when only
one thread is reading, it still locks. Wasteful for most real scenarios.
-----------------------------------------------------------------------------------------------------------------------------------
✅ Modern replacement — CopyOnWriteArrayList: CopyOnWriteArrayList<String> from java.util.concurrent. Write operations create a fresh
copy of the array — reads never block because they always read from a stable snapshot. Much better for scenarios where reads vastly
outnumber writes. Import: import java.util.concurrent.CopyOnWriteArrayList.
-----------------------------------------------------------------------------------------------------------------------------------
ArrayList result: 1856 ← data lost — race condition
Vector result: 2000 ← always correct
CopyOnWriteArrayList result:2000 ← correct + better for read-heavy

Skills: thread safety proof, race condition, join(), CopyOnWriteArrayList, synchronized vs copy-on-write strategy
Hint at bottom --->
 */

package List.Vector;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class MultiThreadedTicketCounter {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("------------------ Using ArrayList -------------------");
        ArrayList<String> arrayList = new ArrayList<>();
        Runnable taskA = () -> {
            for(int i = 1; i <= 1000; i++){
                arrayList.add("Ticket"+i);
            }
        };

        Thread t1 = new Thread(taskA);
        Thread t2 = new Thread(taskA);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Total: "+arrayList.size());

        System.out.println("------------------ Using Vector ------------------");
        Vector<String> vector = new Vector<>();
        Runnable taskV = () -> {
            for(int i = 1; i <= 1000; i++){
                vector.add("Ticket"+i);
            }
        };
        Thread t3 = new Thread(taskV);
        Thread t4 = new Thread(taskV);
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("Total: "+vector.size());

        System.out.println("------------------- Using CopyOnWriteArrayList -----------------");
        CopyOnWriteArrayList<String> cp = new CopyOnWriteArrayList<>();
        Runnable taskC = () -> {
          for(int i = 1; i <= 1000; i++){
              cp.add("Ticket"+i);
          }
        };
        Thread t5 = new Thread(taskC);
        Thread t6 = new Thread(taskC);
        t5.start();
        t6.start();
        t5.join();
        t6.join();
        System.out.println("Total: "+cp.size());

    }
}


/*
Setup — two threads adding simultaneously:
Runnable task = () -> { for(int i=0; i<1000; i++) list.add("ticket"+i); };
Thread t1 = new Thread(task);
Thread t2 = new Thread(task);
t1.start(); t2.start(); t1.join(); t2.join();
System.out.println("Total: " + list.size());

Run this three times: once with ArrayList (size varies each run — proves race condition), once with Vector (always 2000),
once with CopyOnWriteArrayList (always 2000).

Why ArrayList loses tickets: list.add() internally does — check size, grow if needed, place element, increment size counter.
Two threads can both read same size, both try to write at same index — one overwrites the other. Net result: one ticket lost.

Modern CopyOnWriteArrayList:
CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>()
Every write creates a new internal array copy — thread that was reading the old copy is unaffected. Expensive for write-heavy
scenarios but perfect for read-heavy with occasional writes.
 */
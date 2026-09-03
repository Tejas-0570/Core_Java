/*
#8 Medium LinkedList vs ArrayList — performance
-----------------------------------------------------------------------------------------------------------------------------------
Performance battle — insert at front 10000 times

This is a concept proof problem. Insert 10000 elements at the FRONT (index 0) — once using ArrayList, once using LinkedList.
Measure time taken for each using System.currentTimeMillis(). Print the difference. Then do the same for get(index) —
show where ArrayList wins back.
-----------------------------------------------------------------------------------------------------------------------------------
This IS the why: This problem does not simulate anything — it directly proves in milliseconds on your own machine why LinkedList exists.
You will see the number difference yourself, and it will never leave your memory.
-----------------------------------------------------------------------------------------------------------------------------------
Insert 10000 at front:
ArrayList time: ~180ms ← shifting 10000 elements each time
LinkedList time: ~5ms ← just pointer change each time
Random get(5000):
ArrayList time: ~1ms ← direct index access O(1)
LinkedList time: ~8ms ← must traverse from head O(n)

Skills: System.currentTimeMillis(), O(1) vs O(n) proven empirically, ArrayList internal array, LinkedList node traversal
Hint at bottom -->
 */

package List.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class PerformanceBattle {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();

//      ================ Insertion ==================
        long startA = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            arrayList.add(0,"item"+i);
        }
        long endA = System.currentTimeMillis();
        System.out.println("Arraylist Insert Time: "+(endA-startA));

        long startL = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            linkedList.add(0,"item"+i);
        }
        long endL = System.currentTimeMillis();
        System.out.println("LinkedList Insert Time: "+(endL-startL));

//      ================ Searching/ Get Element ==================
        int trials = 100000;

        int testIndex = 50000;   // middle — worst case for LinkedList traversal

        long getTimeStartA = System.currentTimeMillis();
        for(int i = 0; i < trials; i++){
            arrayList.get(testIndex);
        }
        long getTimeEndA = System.currentTimeMillis();
        System.out.println("Accessing Time for ArrayList: " + (getTimeEndA - getTimeStartA) + "ms");

        long getTimeStartL = System.currentTimeMillis();
        for(int i = 0; i < trials; i++){
            linkedList.get(testIndex);
        }
        long getTimeEndL = System.currentTimeMillis();
        System.out.println("Accessing Time for LinkedList: " + (getTimeEndL - getTimeStartL) + "ms");

    }
}


/*
Measuring time: long start = System.currentTimeMillis(); — run your loop — long end = System.currentTimeMillis(); —
System.out.println("Time: " + (end-start) + "ms"). Wrap each operation in this pattern.

Front insertion loop: for(int i = 0; i < 10000; i++) { list.add(0, "item" + i); } — same code for both, just change the list type.

Why ArrayList is slow at front insert: add(0, element) copies ALL existing elements one position right using System.arraycopy internally.
10000th insertion copies 9999 elements. Total work = 0+1+2+...+9999 = ~50 million operations.

Why LinkedList is slow at get(index): No direct index access — must start from head node and follow next pointers until reaching index.
get(5000) traverses 5000 nodes. ArrayList stores elements in a real array — get(5000) is literally array[5000] — instant.

The permanent rule from this problem: Frequent front/middle insert-delete → LinkedList. Frequent random access by index → ArrayList.
 */
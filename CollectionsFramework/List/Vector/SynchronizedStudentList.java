/*
#1 Easy Vector basics
-----------------------------------------------------------------------------------------------------------------------------------
Synchronized student list

Create a Vector of student names. Use all core Vector-specific methods — addElement(), elementAt(), removeElement(), firstElement(),
lastElement(), size(), capacity(). Then do the same with ArrayList and compare — notice Vector has extra legacy methods alongside
standard List methods.
-----------------------------------------------------------------------------------------------------------------------------------
⚠️ Legacy approach — Vector: Vector doubles its capacity when full (default initial capacity 10, grows to 20, 40...).
Every method is synchronized — even single-threaded reads lock the object unnecessarily. This makes Vector slower than ArrayList
in single-threaded programs — you pay synchronization cost even when you don't need thread safety.
-----------------------------------------------------------------------------------------------------------------------------------
✅ Modern replacement — ArrayList: Use ArrayList for all single-threaded scenarios. If thread safety is needed later,
wrap it — Collections.synchronizedList(new ArrayList<>()) gives you a synchronized ArrayList on demand without always paying the cost.
Same methods, no legacy baggage.
-----------------------------------------------------------------------------------------------------------------------------------
addElement("Raj") → Vector specific — same as add()
elementAt(0) → Vector specific — same as get()
firstElement() → "Raj"
capacity() → 10 (even with 3 elements — pre-allocated)
size() → 3 (actual elements)

Skills: addElement(), elementAt(), capacity() vs size(), firstElement(), lastElement(), Vector growth behavior
Hint at bottom --->
 */

package List.Vector;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Collections;
import java.util.List;

public class SynchronizedStudentList {
    public static void main(String[] args) {
        Vector<String> name = new Vector<>();

        name.addElement("Raj");
        name.addElement("Sara");
        name.addElement("Ali");
        System.out.println("Last element: " + name.lastElement());
        boolean removed = name.removeElement("Sara");
        System.out.println("Removed 'Sara'? " + removed);
        System.out.println("After removal: " + name);
        System.out.println("First Element: "+name.elementAt(0));
        System.out.println("Size: " + name.size() + " | Capacity: " + name.capacity());
        // with 2 elements: Size: 2 | Capacity: 10  <-- capacity pre-allocated, unused space exists

        for(int i = 0; i < 10; i++){
            name.addElement("Extra" + i);
        }
        System.out.println("After adding more - Size: " + name.size() + " | Capacity: " + name.capacity());
        // once size exceeds 10, capacity should jump to 20 (doubling behavior)

        System.out.println("-------------------- Test ----------------------");
        int trials = 1000000;

        Vector<String> vecTest = new Vector<>();
        long startV = System.currentTimeMillis();
        for(int i = 0; i < trials; i++){
            vecTest.addElement("item" + i);
        }
        long endV = System.currentTimeMillis();
        System.out.println("Vector add time: " + (endV - startV) + "ms");

        ArrayList<String> listTest = new ArrayList<>();
        long startL = System.currentTimeMillis();
        for(int i = 0; i < trials; i++){
            listTest.add("item" + i);
        }
        long endL = System.currentTimeMillis();
        System.out.println("ArrayList add time: " + (endL - startL) + "ms");


        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        syncList.add("Raj");
        System.out.println("Synchronized wrapper works too: " + syncList);
    }
}

/*
Legacy Vector implementation:
Vector<String> v = new Vector<>() — default capacity 10.
v.addElement("Raj") — legacy add, same as v.add().
v.elementAt(0) — legacy get, same as v.get(0).
v.removeElement("Raj") — removes first occurrence, returns boolean.
v.firstElement() / v.lastElement() — throws NoSuchElementException if empty.
v.capacity() — pre-allocated internal array size. capacity() does NOT exist in ArrayList — Vector specific.
v.size() — actual number of elements. size() <= capacity() always.

Key observation to print: After adding 3 elements, print both size() and capacity(). size=3, capacity=10.
This shows Vector pre-allocates more memory than needed — trades memory for fewer resize operations.

Modern ArrayList implementation:
ArrayList<String> a = new ArrayList<>() — no capacity() method available.
All standard methods: add(), get(), remove(), size() — same behavior but no synchronization overhead.
Print time for 100000 additions on both and compare — ArrayList will be measurably faster.
 */
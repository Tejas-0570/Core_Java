/*
#4 Medium Custom capacity and growth
-----------------------------------------------------------------------------------------------------------------------------------
Memory-aware log collector

Create a Vector with initial capacity 5 and capacity increment 3 (grows by 3 each time, not doubles). Add logs one by one and print
capacity after each addition to observe controlled growth. Compare with default Vector (doubles) and ArrayList (grows by 50%).
Show how controlled growth saves memory.
-----------------------------------------------------------------------------------------------------------------------------------
⚠️ Legacy approach — Vector: Vector(initialCapacity, capacityIncrement) constructor lets you control exactly how much it grows.
Default Vector doubles — 10→20→40 — wastes memory when you know approximate size. This fine-grained control is Vector's one genuine
advantage over ArrayList for memory-constrained scenarios.
-----------------------------------------------------------------------------------------------------------------------------------
✅ Modern replacement — ArrayList with initial capacity: new ArrayList<>(initialCapacity) — sets starting size to avoid early resizing.
You cannot control growth increment but you can hint the starting size. For truly memory-critical code, use arrays directly.
ArrayList grows by 50% each time — 10→15→22→33.
-----------------------------------------------------------------------------------------------------------------------------------
Vector(5, 3) — add logs one by one:
After 5 logs: capacity=5 (no resize yet)
After 6 logs: capacity=8 (grew by 3)
After 9 logs: capacity=11 (grew by 3 again)
Default Vector:capacity=10→20 (doubles — wastes 14 slots for 11 items)

Skills: Vector(capacity, increment) constructor, capacity() observation, growth comparison, ArrayList(initialCapacity)
Hint at bottom --->
 */


package List.Vector;

import java.util.Vector;

public class MemoryAwareLogCollector {
    public static void main(String[] args) {
        System.out.println("---------- new Vector<>(5, 3) - capacity 5, grows by exactly 3 --------- ");
        Vector<String> logs = new Vector<>(5, 3);
        for(int i = 1; i <= 12; i++){
            logs.add("Log"+i);
            System.out.println("Size: "+logs.size()+" | Capacity: "+logs.capacity());
        }

        System.out.println("\n---------- new Vector<>(20) - capacity 20, doubles ---------");
        Vector<String> logs2 = new Vector<>(20);
        for(int i = 1; i <= 45; i++){
            logs2.add("Log"+i);
            System.out.println("Size: "+logs2.size()+" | Capacity: "+logs2.capacity());
        }

        System.out.println("\n--------- new Vector<>() -------------");
        Vector<String> logs3 = new Vector<>();
        for(int i = 1; i <= 25; i++){
            logs3.add("Log"+i);
            System.out.println("Size: "+logs3.size()+" | Capacity: "+logs3.capacity());
        }
    }
}

/*
Controlled growth Vector:
Vector<String> logs = new Vector<>(5, 3) — initial capacity 5, grows by 3 each time.
Loop adding logs: for(int i=1; i<=12; i++) { logs.addElement("Log-"+i); System.out.println("Size: "+logs.size()+" | Capacity: "+logs.capacity()); }

Default Vector for comparison:
Vector<String> def = new Vector<>() — initial 10, doubles to 20 when full.
Add 11 elements and print capacity — shows 20 even though only 11 needed. Wasted 9 slots.

Three constructors to know:
new Vector<>() — capacity 10, doubles
new Vector<>(20) — capacity 20, doubles
new Vector<>(5, 3) — capacity 5, grows by exactly 3

Modern ArrayList with initial capacity:
new ArrayList<>(5) — starts at 5, grows by 50% automatically. No capacity() method to observe — encapsulated internally. Print size() only.
 */

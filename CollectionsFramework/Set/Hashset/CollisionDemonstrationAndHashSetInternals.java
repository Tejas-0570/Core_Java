/*
#7 Medium Hash collision and load factor
-----------------------------------------------------------------------------------------------------------------------------------
Collision demonstration and HashSet internals

Create a class BadHash where ALL instances return the same hashCode() — simulate worst-case collision. Add 1000 objects and measure
contains() time — show it degrades to O(n). Then fix with proper hashCode — show O(1) restored. Also demonstrate HashSet initial
capacity and load factor through timed insertion tests.
-----------------------------------------------------------------------------------------------------------------------------------
🟡 Why this matters — bad hashCode kills HashSet performance: If all objects land in the same bucket, HashSet becomes a LinkedList
internally — O(n) for everything. A HashSet is only as fast as its hashCode implementation. This is why Java String's hashCode is
carefully engineered. When you write custom classes, a lazy hashCode like always returning 1 silently destroys your entire
collection's performance.
-----------------------------------------------------------------------------------------------------------------------------------
🔵 Java 8 improvement — treeification: In Java 8+, when a bucket has more than 8 elements (collision threshold), HashSet converts
that bucket from a LinkedList to a Red-Black Tree internally. This changes worst-case from O(n) to O(log n) for that bucket.
Still far worse than O(1) with proper hashCode — but Java 8 saves you from complete disaster with bad hash implementations.
-----------------------------------------------------------------------------------------------------------------------------------
🟣 Concept — Load factor and rehashing: HashSet default initial capacity = 16 buckets. Load factor = 0.75 (75%). When elements
exceed 16 × 0.75 = 12, HashSet creates a new array of 32 buckets and rehashes ALL elements (expensive O(n) operation). If you
know you will store 1000 elements, create new HashSet<>(1334) — (1000/0.75 ≈ 1334) — prevents rehashing entirely. Rehashing
during insertion causes sudden performance spikes.
-----------------------------------------------------------------------------------------------------------------------------------
BadHash (hashCode always 1):
contains() for 1000 items: ~45ms — O(n) degraded
GoodHash (proper hashCode):
contains() for 1000 items: ~1ms — O(1) maintained
Pre-sized HashSet(1334): no rehashing — faster bulk insert

Skills: hashCode design, collision demonstration, load factor, initial capacity tuning, O(n) degradation proof, Java 8 treeification
Hint at bottom --->
 */

package Set.Hashset;

public class CollisionDemonstrationAndHashSetInternals {
    public static void main(String[] args) {

    }
}

/*
BadHash class:
class BadHash {
int id;
BadHash(int id) { this.id = id; }
@Override public int hashCode() { return 1; } // always same bucket!
@Override public boolean equals(Object o) { return ((BadHash)o).id == this.id; }
}

GoodHash class: same but return Objects.hash(id)

Measure both:
Add 1000 objects to each HashSet. Then search for 500 of them 100 times each.
Measure with System.currentTimeMillis(). Print time difference.

Pre-sized HashSet:
HashSet<String> optimised = new HashSet<>(1334, 0.75f)
Constructor: (initialCapacity, loadFactor). Add 1000 elements — no rehashing occurs.
Compare insertion time vs default HashSet with same 1000 elements.

Custom load factor:
Lower load factor (0.5) = less collision, more memory used.
Higher load factor (0.9) = more collision, less memory used.
Default 0.75 is the carefully tuned balance Java chose.
 */
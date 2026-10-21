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

import java.util.HashSet;
import java.util.Objects;

public class CollisionDemonstrationAndHashSetInternals {

    static final int OBJECTS = 1000;
    static final int SEARCH_COUNT = 500;
    static final int REPEATS = 100;

    public static void main(String[] args) {

        // ---------- Experiment 1: bad hash vs good hash ----------
        HashSet<BadHash> badSet = new HashSet<>();
        HashSet<GoodHash> goodSet = new HashSet<>();
        for (int i = 0; i < OBJECTS; i++) {
            badSet.add(new BadHash(i));
            goodSet.add(new GoodHash(i));
        }

        // warm-up so the JIT compiler doesn't distort the first measurement
        searchBad(badSet);
        searchGood(goodSet);

        long t1 = System.nanoTime();
        searchBad(badSet);
        long badTime = System.nanoTime() - t1;

        long t2 = System.nanoTime();
        searchGood(goodSet);
        long goodTime = System.nanoTime() - t2;

        System.out.println("=== contains(): " + SEARCH_COUNT + " items x " + REPEATS + " repeats ===");
        System.out.println("BadHash  (hashCode always 1): " + badTime / 1_000_000.0 + " ms");
        System.out.println("GoodHash (Objects.hash)     : " + goodTime / 1_000_000.0 + " ms");

        // ---------- Experiment 2: treeification (Java 8+) ----------
        HashSet<ComparableBadHash> treeSet = new HashSet<>();
        for (int i = 0; i < OBJECTS; i++) {
            treeSet.add(new ComparableBadHash(i));
        }
        searchComparable(treeSet); // warm-up
        long t3 = System.nanoTime();
        searchComparable(treeSet);
        long treeTime = System.nanoTime() - t3;
        System.out.println("BadHash + Comparable (tree) : " + treeTime / 1_000_000.0 + " ms");

        // ---------- Experiment 3: initial capacity and rehashing ----------
        int n = 2_000_000;

        long t4 = System.nanoTime();
        HashSet<Integer> defaultSet = new HashSet<>();           // 16 buckets, rehashes many times
        for (int i = 0; i < n; i++) defaultSet.add(i);
        long defaultTime = System.nanoTime() - t4;

        long t5 = System.nanoTime();
        HashSet<Integer> presized = new HashSet<>((int) (n / 0.75f) + 1, 0.75f); // no rehashing
        for (int i = 0; i < n; i++) presized.add(i);
        long presizedTime = System.nanoTime() - t5;

        System.out.println("\n=== Inserting " + n + " Integers ===");
        System.out.println("Default HashSet : " + defaultTime / 1_000_000.0 + " ms");
        System.out.println("Pre-sized       : " + presizedTime / 1_000_000.0 + " ms");
    }

    static void searchBad(HashSet<BadHash> set) {
        for (int r = 0; r < REPEATS; r++)
            for (int i = 0; i < SEARCH_COUNT; i++)
                set.contains(new BadHash(i));
    }

    static void searchGood(HashSet<GoodHash> set) {
        for (int r = 0; r < REPEATS; r++)
            for (int i = 0; i < SEARCH_COUNT; i++)
                set.contains(new GoodHash(i));
    }

    static void searchComparable(HashSet<ComparableBadHash> set) {
        for (int r = 0; r < REPEATS; r++)
            for (int i = 0; i < SEARCH_COUNT; i++)
                set.contains(new ComparableBadHash(i));
    }
}

// Worst case: every instance lands in the same bucket
class BadHash {
    private final int id;
    BadHash(int id) { this.id = id; }

    @Override
    public int hashCode() { return 1; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BadHash)) return false;
        return this.id == ((BadHash) o).id;
    }
}

// Same class, proper hashCode: spread across buckets
class GoodHash {
    private final int id;
    GoodHash(int id) { this.id = id; }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodHash)) return false;
        return this.id == ((GoodHash) o).id;
    }
}

// Bad hash, BUT Comparable, so Java 8's tree bins can order the keys
class ComparableBadHash implements Comparable<ComparableBadHash> {
    private final int id;
    ComparableBadHash(int id) { this.id = id; }

    @Override
    public int hashCode() { return 1; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComparableBadHash)) return false;
        return this.id == ((ComparableBadHash) o).id;
    }

    @Override
    public int compareTo(ComparableBadHash other) {
        return Integer.compare(this.id, other.id);
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
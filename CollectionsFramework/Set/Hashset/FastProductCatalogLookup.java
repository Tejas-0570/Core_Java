/*
#5 Medium HashSet performance — O(1) proof
-----------------------------------------------------------------------------------------------------------------------------------
Fast product catalog lookup

Load 100000 product codes into HashSet and into ArrayList. Then search for 1000 specific codes in both. Measure time for each.
Print the difference. This proves HashSet contains() is O(1) regardless of size while ArrayList contains() is O(n). For large
catalogs the difference is not milliseconds — it is seconds.
-----------------------------------------------------------------------------------------------------------------------------------
🟡 Why HashSet over ArrayList for lookup-heavy tasks: ArrayList.contains() scans from index 0 until found — average n/2 comparisons.
For 100000 products that is 50000 comparisons per search. 1000 searches = 50 million comparisons. HashSet.contains() computes hashCode,
goes directly to bucket, checks 1-2 elements — typically 1 comparison. 1000 searches = ~1000 comparisons. This is the real-world
performance gap that makes HashSet the right choice for membership testing.
-----------------------------------------------------------------------------------------------------------------------------------
🔵 When ArrayList lookup is fine: Small collections (under 1000 elements) — the difference is microseconds, not worth the complexity.
If you also need ordering or index access, ArrayList's O(n) search may be acceptable. Profile first, optimize second. But for large
membership testing — HashSet is always the answer.
-----------------------------------------------------------------------------------------------------------------------------------
🟣 Concept — O(1) does not mean zero time, it means constant time: O(1) means time does not grow with collection size. Searching in a
HashSet of 100 or 100000 elements takes approximately the same time. O(n) means time grows linearly — 10x more elements = 10x more
time. Hash collisions can degrade HashSet to O(n) in worst case but Java's implementation keeps this extremely rare through good
hash distribution. With Java's String.hashCode() — collisions are practically negligible.
-----------------------------------------------------------------------------------------------------------------------------------
Load 100000 product codes — search 1000 codes:
ArrayList contains() time: ~320ms
HashSet contains() time: ~4ms
HashSet is ~80x faster ← you will see this on your machine

Skills: O(1) vs O(n) empirical proof, System.currentTimeMillis(), performance measurement, JVM warmup awareness
Hint at bottom ----->
 */


package Set.Hashset;

public class FastProductCatalogLookup {
    public static void main(String[] args) {

    }
}

/*
Setup — load data:
ArrayList<String> list = new ArrayList<>()
HashSet<String> set = new HashSet<>()
for(int i=0; i<100000; i++) { list.add("PROD-"+i); set.add("PROD-"+i); }

Generate search targets:
String[] searches = new String[1000]
for(int i=0; i<1000; i++) searches[i] = "PROD-"+(i*100) — spread across range.

Measure ArrayList:
long start = System.currentTimeMillis()
for(String s : searches) list.contains(s)
long listTime = System.currentTimeMillis() - start

Measure HashSet:
Same pattern with set.contains(s).

Print comparison:
System.out.println("ArrayList: "+listTime+"ms")
System.out.println("HashSet: "+setTime+"ms")
System.out.println("HashSet is ~"+(listTime/setTime)+"x faster")

Warm up the JVM: Run one dummy search loop before measuring — JVM's JIT compiler optimises after first run, affecting timing. Discard first run's time.
 */
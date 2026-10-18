/*
#10 Hard HashSet limitations — when NOT to use it
-----------------------------------------------------------------------------------------------------------------------------------
HashSet vs LinkedHashSet vs TreeSet — the final verdict

Build a leaderboard system three times — once with HashSet, once with LinkedHashSet, once with TreeSet. Same data, same operations:
add scores, check existence, iterate and print. Observe and print differences in output order. Write clear decision comments in code —
when each Set implementation is the right tool.
-----------------------------------------------------------------------------------------------------------------------------------
🟡 HashSet limitations that this problem exposes: HashSet gives NO ordering guarantee — print order is unpredictable and changes
between runs. No get(index). No first() or last(). Cannot get min or max without iterating everything. If your problem needs unique
elements AND order — HashSet is wrong. This problem forces you to discover exactly when HashSet falls short and which Set
implementation to reach for instead.
-----------------------------------------------------------------------------------------------------------------------------------
🔵 The three choices summarised: HashSet — fastest O(1), no order, use when order irrelevant (caches, membership tests, deduplication).
LinkedHashSet — slightly slower, insertion order maintained, use when you need unique + arrival order (recent items, LRU cache basis).
TreeSet — O(log n), always sorted, use when you need unique + sorted order (leaderboards, priority lists, range queries).
-----------------------------------------------------------------------------------------------------------------------------------
🟣 Concept — All three implement Set interface: HashSet, LinkedHashSet, and TreeSet all implement Set — no duplicates, no index access.
They are interchangeable in code that uses Set as reference type: Set<String> s = new HashSet<>(). Switching implementation is one
word change. This is the power of programming to interfaces — your logic does not change, only the underlying behavior (order, speed)
changes. TreeSet additionally implements SortedSet and NavigableSet — giving extra methods like first(), last(), headSet(), tailSet().
-----------------------------------------------------------------------------------------------------------------------------------
Input: Sara-92, Raj-78, Ali-92, John-88, Priya-65 (using score as key)
HashSet print: unpredictable order every run
LinkedHashSet print: Sara, Raj, Ali, John, Priya — insertion order
TreeSet print: 65, 78, 88, 92 — sorted, 92 appears once (duplicate removed)
TreeSet first(): 65 | last(): 92 | headSet(80): [65,78]

Skills: Set interface, HashSet vs LinkedHashSet vs TreeSet, first(), last(), headSet(), tailSet(), programming to interface, decision criteria
Hint at bottom --->
 */

package Set.Hashset;

public class HashSet_vs_LinkedHashSet_vs_TreeSet {
    public static void main(String[] args) {

    }
}

/*
Setup — three sets, same data:
Set<Integer> hashSet = new HashSet<>()
Set<Integer> linkedSet = new LinkedHashSet<>()
Set<Integer> treeSet = new TreeSet<>()
Add same scores to all three. Print each set and observe order difference.

TreeSet extra methods — requires TreeSet reference not Set:
TreeSet<Integer> ts = (TreeSet<Integer>) treeSet or declare as TreeSet directly.
ts.first() — smallest element
ts.last() — largest element
ts.headSet(80) — all elements less than 80
ts.tailSet(80) — all elements greater than or equal to 80
ts.subSet(70, 90) — elements between 70 and 90

Decision comments to write in your code:
// HashSet: unique + fastest + order irrelevant
// LinkedHashSet: unique + insertion order needed
// TreeSet: unique + always sorted + range queries needed
// Default when unsure: HashSet. Add order when required.

Performance comparison print:
Time add() of 100000 elements in all three. HashSet fastest, LinkedHashSet similar, TreeSet slowest (O(log n) per add vs O(1)).
 */
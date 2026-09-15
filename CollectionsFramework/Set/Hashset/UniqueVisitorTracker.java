/*
#1 Easy HashSet basics + no duplicates
-----------------------------------------------------------------------------------------------------------------------------------
Unique visitor tracker

A website tracks every user visit. Same user can visit multiple times but must be counted only once. Take 10 visit logs (some duplicate
usernames) as input. Store in HashSet — duplicates are silently rejected. Print unique visitors and total unique count. Do same with
ArrayList and show duplicate problem.
-----------------------------------------------------------------------------------------------------------------------------------
🟡 Why HashSet not ArrayList/List: ArrayList stores every single entry including duplicates — you would need to manually check contains()
before every add() which is O(n) per insertion. HashSet rejects duplicates automatically during add() — O(1) per insertion using hashing.
For 1 million visits, ArrayList duplicate check = 1 million O(n) checks. HashSet = 1 million O(1) checks. No contest.
-----------------------------------------------------------------------------------------------------------------------------------
🔵 Alternative — LinkedHashSet: If you also need to remember the order visitors first arrived, use LinkedHashSet — same O(1) duplicate
rejection but maintains insertion order. HashSet gives no order guarantee — print order may differ every run. For pure "unique only,
order irrelevant" — HashSet is fastest.
-----------------------------------------------------------------------------------------------------------------------------------
🟣 Concept — How HashSet rejects duplicates: When you call add("Raj"), HashSet internally calls "Raj".hashCode() to get a number
(bucket index). It then checks if that bucket already has "Raj" using equals(). If yes — rejected silently, add() returns false.
If no — stored. Two equal strings always produce the same hashCode — this is the contract. This is why HashSet add() is O(1) — no loop,
no comparison with every existing element, just one hashCode calculation and one equals check.
-----------------------------------------------------------------------------------------------------------------------------------
Visits: Raj,Sara,Raj,Ali,Sara,John,Raj,Priya,Ali,John
HashSet:[Sara, Raj, Ali, John, Priya] — 5 unique (order not guaranteed)
add("Raj") returns: false — already exists
ArrayList: stores all 10 including duplicates — wrong for this use case

Skills: add() return value, contains(), no-index iteration, O(1) operations, duplicate rejection proof
Hint at bottom --->
 */


package Set.Hashset;

public class UniqueVisitorTracker {
    public static void main(String[] args) {

    }
}


/*
HashSet setup:
HashSet<String> visitors = new HashSet<>()
Scanner sc = new Scanner(System.in)
Loop 10 times: boolean added = visitors.add(sc.nextLine())
if(!added) System.out.println("Duplicate — already counted")
add() returns true if added, false if duplicate — use this boolean for feedback.

Print all unique visitors: enhanced for-each — for(String v : visitors) — no index, no get(). HashSet has no get(index) method.
Iteration order is NOT insertion order — different every run.

Check existence: visitors.contains("Raj") — O(1). Same hashing mechanism.

Show ArrayList problem:
ArrayList<String> list = new ArrayList<>()
Add same 10 entries — list.size() = 10. HashSet size = 5. Print both to show difference.
Manual dedup in ArrayList: if(!list.contains(name)) list.add(name) — works but O(n) per check.

Key methods: add(), contains(), size(), remove(), isEmpty(), iterator().
 */
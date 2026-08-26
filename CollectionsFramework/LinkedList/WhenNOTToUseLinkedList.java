/*
#10 Hard LinkedList vs ArrayList — final verdict

When NOT to use LinkedList

Build a leaderboard system for a game with 1000 players. Operations needed: get player at rank 5, update score at rank 10,
sort by score, search player by name. Implement in both LinkedList and ArrayList. Show through code and timing WHY ArrayList
wins here — and write a clear decision comment in your code.

The full picture: LinkedList has a hidden cost most beginners miss — every element is a separate Node object in heap memory
with two extra pointer references (next, previous). For 1000 players that is 1000 extra objects + 2000 extra pointers.
ArrayList stores everything in one contiguous array — much better for CPU cache. This problem shows LinkedList is NOT always better.

getRank(5): ArrayList → array[4] instant | LinkedList → traverse 5 nodes
sort(): ArrayList → faster (cache friendly) | LinkedList → slower
search(): both O(n) — same
Verdict: Leaderboard → ArrayList wins clearly

Skills: empirical comparison, cache efficiency concept, getRank by index, Collections.sort() timing, final decision rule
Hint at bottom --->
 */

package LinkedList;

public class WhenNOTToUseLinkedList {
    public static void main(String[] args) {

    }
}


/*
Player class: name, score, rank — constructor + getters + setters.

Populate both lists: Use a loop — generate 1000 players with random scores using Math.random(). Add same players to both ArrayList
and LinkedList.

getRank(int r): System.currentTimeMillis() before and after list.get(r-1) on both. ArrayList is array lookup — near zero time.
LinkedList traverses r-1 nodes.

Sort comparison: Time Collections.sort() on both. ArrayList is faster because CPU loads contiguous array memory into cache efficiently.
LinkedList nodes are scattered in heap — cache misses slow it down.

The decision comment to write in your code:
// Use LinkedList when: frequent add/remove at front or middle
// Use ArrayList when: frequent access by index, sorting, searching
// Default choice when unsure: ArrayList
 */
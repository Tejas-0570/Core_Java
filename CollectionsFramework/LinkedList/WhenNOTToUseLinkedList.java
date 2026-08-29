/*
#10 Hard LinkedList vs ArrayList — final verdict
-----------------------------------------------------------------------------------------------------------------------------------
When NOT to use LinkedList

Build a leaderboard system for a game with 1000 players. Operations needed: get player at rank 5, update score at rank 10,
sort by score, search player by name. Implement in both LinkedList and ArrayList. Show through code and timing WHY ArrayList
wins here — and write a clear decision comment in your code.
-----------------------------------------------------------------------------------------------------------------------------------
The full picture: LinkedList has a hidden cost most beginners miss — every element is a separate Node object in heap memory
with two extra pointer references (next, previous). For 1000 players that is 1000 extra objects + 2000 extra pointers.
ArrayList stores everything in one contiguous array — much better for CPU cache. This problem shows LinkedList is NOT always better.
-----------------------------------------------------------------------------------------------------------------------------------
getRank(5): ArrayList → array[4] instant | LinkedList → traverse 5 nodes
sort(): ArrayList → faster (cache friendly) | LinkedList → slower
search(): both O(n) — same
Verdict: Leaderboard → ArrayList wins clearly

Skills: empirical comparison, cache efficiency concept, getRank by index, Collections.sort() timing, final decision rule
Hint at bottom --->
 */

package LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class WhenNOTToUseLinkedList {
    public static void main(String[] args) {
        ArrayList<Player> arrayList = new ArrayList<>();
        LinkedList<Player> linkedList = new LinkedList<>();

        for(int i = 1; i <= 1000; i++){
            Player p = new Player("Player"+i, (int)Math.floor(Math.random() * 1000), i);
            arrayList.add(p);
            linkedList.add(p);
        }

//      ------------------ Get Rank() -----------------------------
        int rankToFind = 5;
        int trials = 1000;

        long startA = System.currentTimeMillis();
        for(int i = 0; i < trials; i++){
            arrayList.get(rankToFind-1);
        }
        long endA = System.currentTimeMillis();
        System.out.println("ArrayList get rank time: "+(endA-startA)+"ms");

        long startL = System.currentTimeMillis();
        for(int i = 0; i < trials; i++){
            linkedList.get(rankToFind-1);
        }
        long endL = System.currentTimeMillis();
        System.out.println("LinkedList get rank time: "+(endL-startL)+"ms");

        System.out.println("\n---------------------------------------------------------");

//      --------------------- Update Score ----------------------------
        int rankToUpdate = 20;
        long startA2 = System.currentTimeMillis();
        arrayList.get(rankToFind).setScore(9999);
        long endA2 = System.currentTimeMillis();
        System.out.println("ArrayList update rank time: "+(endA2-startA2)+"ms");

        long startL2 = System.currentTimeMillis();
        linkedList.get(rankToFind).setScore(9999);
        long endL2 = System.currentTimeMillis();
        System.out.println("LinkedList update rank time: "+(endL2-startL2)+"ms");

        System.out.println("\n---------------------------------------------------------");

//      ----------------- Sort -------------------------------
        long sortStartA = System.currentTimeMillis();
        Collections.sort(arrayList, Comparator.comparingInt(Player::getScore));
        long sortEndA = System.currentTimeMillis();
        System.out.println("ArrayList sort time: " + (sortEndA - sortStartA) + "ms");

        long sortStartL = System.currentTimeMillis();
        Collections.sort(linkedList, Comparator.comparingInt(Player::getScore));
        long sortEndL = System.currentTimeMillis();
        System.out.println("LinkedList sort time: " + (sortEndL - sortStartL) + "ms");

        System.out.println("\n---------------------------------------------------------");

//      ----------------- Searching ----------------------------
        String searchName = "Player750";

        long searchStartA = System.currentTimeMillis();
        for(Player p : arrayList){
            if(p.getName().equals(searchName)){
                break;
            }
        }
        long searchEndA = System.currentTimeMillis();
        System.out.println("ArrayList Searching Time: "+(searchEndA-searchStartA)+"ms");

        long searchStartL = System.currentTimeMillis();
        for(Player p : linkedList){
            if(p.getName().equals(searchName)){
                break;
            }
        }
        long searchEndL = System.currentTimeMillis();
        System.out.println("LinkedList Searching Time: "+(searchEndL-searchStartL)+"ms");


// DECISION RULE:
// Use LinkedList when: frequent add/remove at front or middle
// Use ArrayList when: frequent access by index, sorting, searching
// Default choice when unsure: ArrayList
//
// Verdict for THIS problem (leaderboard): getRank/updateScore favor ArrayList (O(1) vs O(n) access),
// sort favors ArrayList (cache-friendly contiguous memory), search is roughly equal (both O(n) sequential scan).
// → ArrayList wins clearly for a leaderboard system.
    }
}

class Player{
    private String name;
    private int score;
    private int rank;

    Player(String name, int score, int rank){
        this.name = name;
        this.score = score;
        this.rank = rank;
    }

//  -------------- Getters --------------
    public String getName(){
        return name;
    }
    public int getScore(){
        return score;
    }
    public int getRank(){
        return rank;
    }

//  ------------- Setters ----------------
    public void setName(String name){
        this.name = name;
    }
    public void setScore(int score){
        this.score = score;
    }
    public void setRank(int rank){
        this.rank = rank;
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
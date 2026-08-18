/*
#1 Easy Structure + front/back operations
---------------------------------------------------------------
Browser history manager

Build a browser history using LinkedList. User visits pages — each new page adds to the front (most recent first).
Options: visit page, go back (remove from front), show full history, show current page (peek front). No shifting of elements ever.

Why LinkedList not ArrayList: Every new page visit inserts at front. In ArrayList, add(0, page) shifts ALL
existing pages right — the more history you have, the slower it gets. LinkedList just creates a new node and
points it to the old front — O(1) always, no shifting ever.

visit("google.com") → [google.com]
visit("youtube.com") → [youtube.com, google.com]
visit("github.com") → [github.com, youtube.com, google.com]
current page: github.com
go back: removed github.com → current: youtube.com

Skills: addFirst(), removeFirst(), peekFirst(), addLast(), isEmpty(), Deque nature of LinkedList
Hint at bottom -->
 */

package LinkedList;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BrowserHistoryManager {
    public static void main(String[] args) {
        HistoryManager hm = new HistoryManager();

        hm.visitPage("google.com");
        hm.visitPage("youtube.com");
        hm.visitPage("github.com");

        hm.goBack();

        hm.showHistory();

        hm.currentPage();
    }
}

class HistoryManager{
    LinkedList<String> history = new LinkedList<>();

    public void visitPage(String website){
        history.addFirst(website);
    }

    public void goBack(){
        try{
            history.removeFirst();
        } catch (NoSuchElementException e){
            System.out.println("Exception: "+e);
        }
    }

    public void showHistory(){
        System.out.println(history);
    }

    public void currentPage(){
        try{
            System.out.println("Current page: "+history.getFirst());
        } catch (NoSuchElementException e){
            System.out.println("Exception: "+e);
        }
    }
}

/*
Setup: LinkedList<String> history = new LinkedList<>(). LinkedList implements both List and Deque interfaces —
so it has methods for both ends.

Add to front: history.addFirst(page) or history.push(page) — both add at front. O(1) — no shifting.

Remove from front: history.removeFirst() — removes and returns front element. Throws NoSuchElementException if empty —
check with history.isEmpty() first.

Peek front (don't remove): history.peekFirst() — returns front without removing. Returns null if empty —
safer than getFirst() which throws exception.

Show full history: enhanced for-each loop — for(String page : history).

Key methods to know: addFirst(), addLast(), removeFirst(), removeLast(), peekFirst(), peekLast(), getFirst(), getLast().
 */
/*
#5 Medium Deque — both ends
-----------------------------------------------------------------------------------------------------------------------------------
Sliding window task processor

Build a task processor that maintains a window of last N tasks. New tasks always add to back. When window is full, oldest task (front)
is automatically removed. Operations: addTask, processAll (remove all from front one by one), peekOldest, peekNewest, isFull.
-----------------------------------------------------------------------------------------------------------------------------------
Why LinkedList not ArrayList: This problem needs BOTH ends simultaneously — add at back, remove from front, peek both ends.
LinkedList implements Deque (Double Ended Queue) — all four end operations are O(1). ArrayList has no efficient front removal — always O(n) shifting.
-----------------------------------------------------------------------------------------------------------------------------------
window size: 3
add("Task1") → [Task1]
add("Task2") → [Task1, Task2]
add("Task3") → [Task1, Task2, Task3] — full
add("Task4") → auto removes Task1 → [Task2, Task3, Task4]
oldest: Task2 | newest: Task4

Skills: Deque concept, addLast(), removeFirst(), peekFirst(), peekLast(), size(), sliding window pattern
Hint at bottom --->
 */

package LinkedList;
import java.util.Iterator;
import java.util.LinkedList;
public class SlidingWindowTaskProcessor {
    public static void main(String[] args) {
        TaskProcessor tp = new TaskProcessor();

        tp.addTask("Task1");
        tp.addTask("Task2");
        tp.addTask("Task3");
        tp.addTask("Task4");

        tp.peekOldest();
        tp.peekNewest();

        tp.isFull();
        tp.processAll();
        tp.isFull();
    }
}

class TaskProcessor{
    LinkedList<String> tasks = new LinkedList<>();

    public void addTask(String task){
        if(tasks.size() == 3){
            removeTask();
            tasks.addLast(task);
            return;
        }
        tasks.addLast(task);
    }

    public void processAll(){
        while(!tasks.isEmpty()){
            System.out.println("Processing "+tasks.pollFirst());
        }
    }

    public void peekOldest(){
        if(tasks.isEmpty()){
            System.out.println("Tasks are empty");
            return;
        }
        System.out.println("Oldest tasks: "+tasks.peekFirst());
    }

    public void peekNewest(){
        if(tasks.isEmpty()){
            System.out.println("Tasks are empty");
            return;
        }
        System.out.println("Newest tasks: "+tasks.peekLast());
    }

    public void isFull(){
        if(tasks.size() == 3){
            System.out.println("Tasks are FULL");
        } else {
            System.out.println("Tasks are NOT FULL");
        }
    }

    public void removeTask(){
        if(tasks.isEmpty()){
            System.out.println("Tasks are empty! No tasks to remove");
            return;
        }
        tasks.removeFirst();
    }
}

/*
Setup: LinkedList<String> window = new LinkedList<>() and int maxSize taken from Scanner.

addTask logic: First check if(window.size() == maxSize) then window.removeFirst() — drop oldest. Then window.addLast(task) — add newest.
This is the sliding window pattern used in real systems for recent activity tracking.

peekOldest: window.peekFirst() — front is oldest since we add to back.
peekNewest: window.peekLast() — back is newest.

processAll: while(!window.isEmpty()) { System.out.println("Processing: " + window.pollFirst()); }

Deque interface methods summary: addFirst/addLast, removeFirst/removeLast, peekFirst/peekLast,
pollFirst/pollLast (poll = remove + return null if empty, safer than remove).
 */
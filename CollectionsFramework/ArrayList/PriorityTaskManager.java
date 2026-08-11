/*
Priority task manager

Build a task list where: normal tasks add to the end, URGENT tasks insert at index 0 (front), and you can insert at any
specific position. Show how add(index, element) differs from add(element). Also implement move task up (swap with previous)
and show the list after each operation.

add("Write report") → [Write report]
add("Send email") → [Write report, Send email]
addUrgent("Fix bug") → [Fix bug, Write report, Send email]
addAt(1,"Review code") → [Fix bug, Review code, Write report, Send email]
moveUp(2) → swaps index 2 with index 1

Skills: add(index, element), set(index, element), indexOf(), insertion shifting concept
Hint present at bottom -->

 */

package ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
public class PriorityTaskManager {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       AddTaskList tasks = new AddTaskList();
       System.out.println("=============== Enter you tasks =================");
       tasks.add("Write Report");
       System.out.println(tasks.list);
       tasks.add("Send Email");
       System.out.println(tasks.list);
       tasks.addUrgent("Fix Bug");
       System.out.println(tasks.list);
       try{
           tasks.addAt(1,"Review Code");
           System.out.println(tasks.list);
       } catch (IndexOutOfBoundsException e){
           System.out.println(e);
       }

       try{
           tasks.moveUp(2);
           System.out.println(tasks.list);
       } catch (IndexOutOfBoundsException e){
           System.out.println(e);
       }
    }
}

class AddTaskList{
    ArrayList<String> list = new ArrayList<>();

    public void add(String task){
        list.add(task);
    }

    public void addUrgent(String task){
//        list.addFirst(task);  --> addFirst method is not present in ArrayList but after JDK 21 ArrayList have addFirst and addList methods.(I am using JDK 17 that's why i wrote add(0, task), if you have JDK >21 then you can directly use addFirst(task))
        list.add(0, task);
    }

    public void addAt(int index, String task) throws IndexOutOfBoundsException{
        list.add(index, task);
    }

    public void moveUp(int index) throws IndexOutOfBoundsException{
        if(index == 0){
            System.out.println("This is first element! There is no any previous element");
            return;
        }
        String temp = list.get(index);
        list.set(index, list.get(index-1));
        list.set(index-1, temp);
    }
}

/*
Hint:

add(element): always adds to the end — O(1) usually.
add(index, element): inserts at that position, shifts everything after it right — O(n) because of shifting.
This is ArrayList's weakness compared to LinkedList for frequent insertions in the middle.

addUrgent: just calls tasks.add(0, taskName) — inserts at front, shifts all existing items right by 1.

moveUp(int index): swap tasks.get(index) with tasks.get(index-1). Use tasks.set(index, tasks.get(index-1))
and tasks.set(index-1, temp). Check index > 0 before swapping — can't move up the first item.

set(index, element): replaces element at index — does NOT shift anything. Different from add(index, element).
 */
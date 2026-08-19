/*
#4 Medium Frequent middle insertion
-----------------------------------------------------------------------------------------------------------------------------------
Train coach manager

A train has coaches in order. Operations: add coach at front, add at back, insert coach between two specific coaches by name,
remove a coach by name, display full train. Show that middle insertion in LinkedList does not shift elements — just pointer changes.
-----------------------------------------------------------------------------------------------------------------------------------
Why LinkedList not ArrayList: Inserting between specific coaches is a middle insertion. ArrayList must shift all coaches after
insertion point — O(n). LinkedList only changes 2 pointers — the previous node points to new node, new node points to next node —
O(1) for the actual insertion (finding position still takes O(n) but insertion itself is O(1)).
-----------------------------------------------------------------------------------------------------------------------------------
add: Engine → [Engine]
addLast: Guard → [Engine, Guard]
addBetween("Engine","Guard","Coach-A"): [Engine, Coach-A, Guard]
addBetween("Coach-A","Guard","Coach-B"): [Engine, Coach-A, Coach-B, Guard]
remove("Coach-A"): [Engine, Coach-B, Guard]

Skills: indexOf(), add(index, element), remove(Object), ListIterator, middle insertion concept
Hint at bottom -->
 */

package LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class TrainCoachManager {
    public static void main(String[] args) {
        TrainCoach tc = new TrainCoach();

        tc.addEngine("Engine");
        tc.addGuard("Guard");
        tc.addBetween("Engine", "Guard", "Coach-A");
        tc.addBetween("Coach-A", "Guard", "Coach-B");
        tc.displayTrain();

        tc.removeCoach("Coach-A");
        tc.displayTrain();

        tc.addBetweenUsingIterator("Coach-B", "Coach-C");
        tc.displayTrain();
    }
}

class TrainCoach{
    LinkedList<String> train = new LinkedList<>();

    public void addEngine(String name){
        if(train.contains(name)){
            System.out.println(name + " already exists in the train — can't add a duplicate engine");
            return;
        }
        train.addFirst(name);
        System.out.println("Added engine --> " + train);
    }

    public void addGuard(String name){
        if(train.contains(name)){
            System.out.println(name + " already exists — can't add a duplicate guard");
            return;
        }
        train.addLast(name);
        System.out.println("Added guard --> " + train);
    }

    public void addBetween(String coach1, String coach2, String newCoach){
        int index1 = train.indexOf(coach1);
        if(index1 == -1){
            System.out.println(coach1 + " not found in train");
            return;
        }
        train.add(index1 + 1, newCoach);
        System.out.println("Inserted " + newCoach + " between " + coach1 + " and " + coach2 + " --> " + train);
    }

    public void removeCoach(String name){
        if(train.remove(name)){
            System.out.println(name + " removed --> " + train);
        } else {
            System.out.println(name + " not found in train");
        }
    }

    public void addBetweenUsingIterator(String afterThis, String newCoach){
        ListIterator<String> it = train.listIterator();
        while(it.hasNext()){
            if(it.next().equals(afterThis)){
                it.add(newCoach);
                System.out.println("Inserted " + newCoach + " after " + afterThis + " --> " + train);
                return;
            }
        }
        System.out.println(afterThis + " not found");
    }

    public void displayTrain(){
        System.out.println("Train: "+train);
    }
}

/*
addBetween logic: Find the index of the first coach using train.indexOf("Engine"). Then use train.add(index + 1, "Coach-A") —
this inserts after Engine. indexOf() returns -1 if not found — check this first and print "Coach not found".

Why add(index, element) is O(1) insertion in LinkedList: LinkedList's ListIterator finds the position by traversing — that part is O(n).
But once found, inserting just changes 2 node pointers — O(1). ArrayList physically moves all elements after the index —
O(n) for the shift itself. So LinkedList wins when you have frequent insertions at known positions.

remove(Object): train.remove("Coach-A") — removes by value. Returns true if removed, false if not found. Use this boolean to
give feedback.

ListIterator for precise insertion:
ListIterator<String> it = train.listIterator();
while(it.hasNext()) { if(it.next().equals("Engine")) { it.add("Coach-A"); break; } } — most efficient way.
 */

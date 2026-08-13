/*
Attendance cleaner

Take a list of student names where some names are entered twice (duplicates) and some are "ABSENT". Remove all duplicates
(keep first occurrence only) and remove all "ABSENT" entries. Use Iterator for safe removal. Show list before and after.
Also use removeIf() as an alternative for ABSENT removal.

Input: [Raj, Sara, ABSENT, Raj, Ali, ABSENT, Sara, John]
After removing ABSENT: [Raj, Sara, Raj, Ali, Sara, John]
After removing duplicates: [Raj, Sara, Ali, John]

Skills: Iterator safe removal, ConcurrentModificationException, removeIf(), contains() for dedup
Hint at bottom -->
 */

package ArrayList;
import java.util.*;
public class AttendanceCleaner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Raj");
        nameList.add("Sara");
        nameList.add("ABSENT");
        nameList.add("Raj");
        nameList.add("Ali");
        nameList.add("ABSENT");
        nameList.add("Sara");
        nameList.add("John");

        Iterator<String> it = nameList.listIterator();

        System.out.println("Input: "+nameList);
        while(it.hasNext()){
            if(it.next().equals("ABSENT")){
                it.remove();
            }
        }
        System.out.println("After removing ABSENT: "+nameList);

        ArrayList<String> unique = new ArrayList<>();
        for(String name : nameList){
            if(!unique.contains(name)){
                unique.add(name);
            }
        }
        System.out.println("After removing Duplicates: "+unique);

    }
}



/*
Why Iterator for removal: If you do for(String s : list) { list.remove(s); } you get ConcurrentModificationException — you
cannot modify a list while for-each is iterating it. Iterator's it.remove() is the safe way.

Remove ABSENT with Iterator: Iterator<String> it = list.iterator(); while(it.hasNext()) { if(it.next().equals("ABSENT")) it.remove(); }

removeIf() alternative: list.removeIf(name -> name.equals("ABSENT")) — cleaner, Java 8+. This is a lambda — just know the
syntax for now.

Remove duplicates: Create a new ArrayList<String> seen = new ArrayList<>(). Loop through original — if(!seen.contains(name))
seen.add(name). This keeps first occurrence. contains() checks using equals() internally.
 */
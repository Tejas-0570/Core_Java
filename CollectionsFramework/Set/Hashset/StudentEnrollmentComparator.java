/*
#2 Easy Set operations — union, intersection, difference
-----------------------------------------------------------------------------------------------------------------------------------
Student enrollment comparator

Two courses — Java and Python. Take enrolled students for each as input. Find: union (enrolled in either), intersection
(enrolled in both), difference (Java only students). Use HashSet's built-in bulk operations — addAll(), retainAll(), removeAll().
These are mathematical Set operations built directly into Java.
-----------------------------------------------------------------------------------------------------------------------------------
🟡 Why HashSet for set operations: addAll(), retainAll(), removeAll() on HashSet are O(n) operations using hashing internally.
Doing intersection manually with two ArrayLists requires nested loops — O(n²). HashSet makes mathematical set theory operations
first-class citizens. This is the mathematical Set concept translated directly to Java.
-----------------------------------------------------------------------------------------------------------------------------------
🔵 Alternative — Java 8 Streams: javaStudents.stream().filter(pythonStudents::contains).collect(Collectors.toSet()) — gives
intersection in one line. Cleaner for complex filtering. But retainAll() is simpler and more readable for basic set operations.
Learn Streams in JDK 8 section — they build on this.
-----------------------------------------------------------------------------------------------------------------------------------
🟣 Concept — Mathematical Set theory in Java: In mathematics — Union(A∪B) = all elements in A or B or both.
Intersection(A∩B) = only elements in both A and B. Difference(A-B) = elements in A but not in B. HashSet implements exactly these.
IMPORTANT: retainAll() and removeAll() MODIFY the original set — always work on a COPY if you need the original preserved.
new HashSet<>(original) creates a copy.
-----------------------------------------------------------------------------------------------------------------------------------
Java: [Raj, Sara, Ali, John, Priya]
Python: [Sara, Ali, Mike, Anna, Priya]
Union: [Raj,Sara,Ali,John,Priya,Mike,Anna] — 7 students
Intersection: [Sara, Ali, Priya] — in both
Java only: [Raj, John] — Java but not Python

Skills: addAll(), retainAll(), removeAll(), copy constructor, mathematical set operations, O(n) bulk ops
Hint at bottom ---->
 */

package Set.Hashset;

import java.util.HashSet;
import java.util.Scanner;

public class StudentEnrollmentComparator {
    public static void main(String[] args) {
        HashSet<String> java = new HashSet<>();
        HashSet<String> python = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter count of Java student: ");
        int jCount = sc.nextInt();
        System.out.print("Enter count of Python student: ");
        int pCount = sc.nextInt();

        for(int i = 0; i < jCount; i++){
            System.out.print("Enter name of student (Java): ");
            java.add(sc.next());
        }

        for(int i = 0; i < pCount; i++){
            System.out.print("Enter name of student (Python): ");
            python.add(sc.next());
        }

//      --------------- Union --------------------------
        HashSet<String> union = new HashSet<>(java);
        union.addAll(python);
        System.out.println("Union: "+union);

//      --------------- Intersection --------------------------
        HashSet<String> intersection = new HashSet<>(java);
        intersection.retainAll(python);
        System.out.println("Intersection: "+intersection);

//      --------------- Java Only --------------------------
        HashSet<String> javaOnly = new HashSet<>(java);
        javaOnly.removeAll(python);
        System.out.println("Java Only: "+javaOnly);

//      --------------- Python Only --------------------------
        HashSet<String> pythonOnly = new HashSet<>(python);
        pythonOnly.removeAll(java);
        System.out.println("Python Only: "+pythonOnly);
    }
}

/*
Setup — two HashSets:
HashSet<String> java = new HashSet<>()
HashSet<String> python = new HashSet<>()
Take N names for each using Scanner loop and add() each.

Union — addAll():
HashSet<String> union = new HashSet<>(java) — copy first!
union.addAll(python) — adds all python students, duplicates ignored automatically.

Intersection — retainAll():
HashSet<String> intersection = new HashSet<>(java) — copy!
intersection.retainAll(python) — REMOVES anyone NOT in python. Only common remain.

Difference — removeAll():
HashSet<String> javaOnly = new HashSet<>(java) — copy!
javaOnly.removeAll(python) — removes anyone who is also in python.

Why copy every time: retainAll() and removeAll() modify the set in place. If you call retainAll() on the original java set,
it gets destroyed. Always copy with new HashSet<>(original) before bulk operations.
 */
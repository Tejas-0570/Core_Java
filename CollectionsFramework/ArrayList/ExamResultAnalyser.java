/*
Exam result analyser

Take marks of 10 students. Using Collections utility methods only — find: min, max, frequency of a specific mark,
sort and take top 3 (subList), copy the list without affecting original, fill a list with a default value, reverse the list.
Show how Collections class is a toolbox for ArrayList operations.

marks: [78,92,65,88,71,92,55,88,92,79]
Max: 92 | Min: 55
frequency(92): 3 times
Top 3 after sort: subList(7,10) → [92,92,92]
Reversed: [92,92,92,88,88,79,78,71,65,55]

Skills: Collections.max/min/frequency/sort/reverse/shuffle/nCopies, subList(), copy constructor, view vs copy
Hint at bottom -->
 */

package ArrayList;
import java.util.ArrayList;
import java.util.Collections;

public class ExamResultAnalyser {
    public static void main(String[] args) {
        StudentsMarks sm = new StudentsMarks();

        sm.addMarks(78);
        sm.addMarks(92);
        sm.addMarks(65);
        sm.addMarks(88);
        sm.addMarks(71);
        sm.addMarks(92);
        sm.addMarks(55);
        sm.addMarks(88);
        sm.addMarks(92);
        sm.addMarks(79);


        System.out.println("Marks: "+sm.marksList);
        sm.maxminMarks();
        sm.frequency(92);
        sm.topThree();
        sm.reverse();
        sm.shuffleMarks();
        sm.nCopies(5,"Sara");
    }
}

class StudentsMarks{
    ArrayList<Integer> marksList = new ArrayList<>();

    public void addMarks(int mark){
        marksList.add(mark);

    }

    public void maxminMarks(){
        System.out.println("MAX: "+Collections.max(marksList)+" | MIN: "+Collections.min(marksList));
    }

    public void frequency(int mark){
        System.out.println("Frequency of "+mark+": "+Collections.frequency(marksList, mark));
    }

    public void topThree(){
        ArrayList<Integer> copy = new ArrayList<>(marksList);
        Collections.sort(copy);
        System.out.println("Top 3 after sort: "+copy.subList(7, 10));
    }

    public void reverse(){
        ArrayList<Integer> copy = new ArrayList<>(marksList);
        Collections.reverse(copy);
        System.out.println("Reverse: "+copy);
    }

    public void shuffleMarks(){
        ArrayList<Integer> copy = new ArrayList<>(marksList);
        Collections.shuffle(copy);
        System.out.println("Shuffled: "+copy);
    }

    public void nCopies(int num, Object o){
        System.out.println(num+" Copies of "+o+": "+Collections.nCopies(num, o));
    }

}

/*
All from java.util.Collections:
— Collections.max(marks) and Collections.min(marks)
— Collections.frequency(marks, 92) — counts occurrences
— Collections.sort(marks) then marks.subList(7, 10) — subList(fromIndex, toIndex) — toIndex is exclusive.
Returns a VIEW of original — changes to subList affect original too.
— Collections.reverse(marks) — reverses in place
— Collections.shuffle(marks) — random order
— Collections.nCopies(5, 0) — creates list of 5 zeros

Safe copy: ArrayList<Integer> copy = new ArrayList<>(marks) — copy constructor. Changes to copy do NOT affect original.
This is different from subList which is a view.

Key insight: Collections (with capital C) is a utility class with static methods — not the Collection interface.
Very different things.
 */
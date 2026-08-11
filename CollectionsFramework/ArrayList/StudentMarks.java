/*
Student marks — 3 ways to iterate

Take marks of N students as input. Store in ArrayList<Integer>. Then print all marks using: 1) traditional for loop with get(i),
2) enhanced for-each loop, 3) Iterator object. Also find sum and average. This shows all iteration styles — understand when to
use which.

Input: 5 students → 78, 92, 65, 88, 71
Style 1: for(int i=0; i<marks.size(); i++) → marks.get(i)
Style 2: for(int m : marks) → m
Style 3: Iterator<Integer> it = marks.iterator()
Average: 78.8

Skills: get(i), for-each, Iterator, hasNext(), next(), it.remove(), ConcurrentModificationException awareness
Hint present at bottom --->
 */

package ArrayList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();
        System.out.print("How many students marks want to add: ");
        int num = sc.nextInt();
        System.out.println("------------- Marks should be between 0-100 -------------");
        for(int i = 0; i < num; i++){
            System.out.print("Enter marks of student "+(i+1)+": ");
            int mark = sc.nextInt();
            if(mark < 0 || mark > 100){
                System.out.println("Invalid marks! Marks must be between 0-100");
                return;
            }
            marks.add(mark);
        }

        System.out.println("\n=================== Using normal for loop ====================");
        for(int i = 0; i < marks.size(); i++){
            System.out.print(marks.get(i)+" ");
        }

        System.out.println("\n=================== Using enhanced for loop ====================");
        for(Integer i: marks){
            System.out.print(i+" ");
        }

        System.out.println("\n=================== Using Iterator object ====================");
        Iterator<Integer> it = marks.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }

        System.out.println("\n---------------------------------------------");
        int markSum = 0;
        for(int i = 0; i < marks.size(); i++){
            markSum += marks.get(i);
        }
        System.out.println("\nSum of Marks: "+markSum);
        System.out.println("\nSum of Marks: "+(double)markSum/marks.size());

    }
}



/*
Style 1 — index loop: for(int i = 0; i < marks.size(); i++) { marks.get(i); } — use when you need the index number.

Style 2 — for-each: for(int m : marks) { } — cleanest, use when index not needed.

Style 3 — Iterator: Iterator<Integer> it = marks.iterator(); while(it.hasNext()) { int m = it.next(); } — import java.util.Iterator.
Use Iterator when you need to REMOVE elements while looping — for-each throws ConcurrentModificationException if you remove during
loop but Iterator's it.remove() is safe.

For sum/average: loop once, keep a running total. Average = (double)sum / marks.size(). Cast to double before dividing or you
get integer division.
 */
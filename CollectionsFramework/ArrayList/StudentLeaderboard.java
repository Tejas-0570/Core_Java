/*
Student leaderboard

Take N student names and marks as input. Store in ArrayList<String> and ArrayList<Integer> at matching indexes.
Sort by marks descending (highest first) — keeping names and marks in sync. Also implement binary search after sorting ascending.
Show rank of each student.

Input: Raj-78, Sara-92, Ali-65, John-88
Sorted: Sara-92, John-88, Raj-78, Ali-65
Rank 1: Sara | Rank 2: John | ...
Search 88: Collections.binarySearch → index found

Skills: Collections.sort(), Collections.reverseOrder(), binarySearch(), parallel list sync problem
Hint at bottom -->
 */

package ArrayList;
import java.util.*;
public class StudentLeaderboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<Integer> markList = new ArrayList<>();

        System.out.print("Enter how many student want to add: ");
        int num = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < num; i++){
            System.out.print("Enter name of Student "+(i+1)+": ");
            String name = sc.nextLine();
            nameList.add(name);

            System.out.print("Enter marks of "+nameList.get(i)+": ");
            int marks = sc.nextInt();
            if(marks < 0 || marks > 100){
                System.out.println("Invalid marks! Marks must be 0-100");
                return;
            }
            markList.add(marks);
            sc.nextLine();
        }

        System.out.println("--------------------------------------");
        System.out.print("Input: ");
        for(int i = 0; i < num; i++){
            System.out.print(nameList.get(i)+"-"+markList.get(i)+", ");
        }
        System.out.println();
        // Focus on sorting marks only we'll automatically align name with marks in same loop. Focusing on both create confusion, focus only on marks.
        // 78, 92, 65, 88
        /*
        for(int i = 0; i < num; i++){
            for(int j = i+1; j < num; j++){
                if(markList.get(i) > markList.get(j)){
                    int temp = markList.get(i);
                    markList.set(i, markList.get(j));
                    markList.set(j, temp);
                }
            }
        } */
        // Now Focus on both names and marks
        for(int i = 0; i < num; i++){
            for(int j = i+1; j < num; j++){
                if(markList.get(i) > markList.get(j)){
                    int tempMarks = markList.get(i);
                    markList.set(i, markList.get(j));
                    markList.set(j, tempMarks);

                    String tempName = nameList.get(i);
                    nameList.set(i, nameList.get(j));
                    nameList.set(j, tempName);
                }
            }
        }

        // Ascending sorting
        System.out.print("Sorted Ascending: ");
        for(int i = 0; i < num; i++){
            System.out.print(nameList.get(i)+"-"+markList.get(i)+", ");
        }
        //Descending sorting
        System.out.println();
        System.out.print("Sorted Descending: ");
        for(int i = num-1; i >= 0; i--){
            System.out.print(nameList.get(i)+"-"+markList.get(i)+", ");
        }
        // Rank
        System.out.println();
        for(int i = num-1, rank = 1; i >= 0; i--, rank++){
            System.out.print("Rank "+rank+": "+nameList.get(i)+" | ");
        }
        System.out.println();
        //Searching
        int result = Collections.binarySearch(markList, 88);
        if(result < 0){
            System.out.println("Element not found");
        } else {
            System.out.println("Element found");
        }
    }
}


/*
Sorting two parallel lists in sync: Use bubble sort logic manually. When you swap marks.get(i) with marks.get(j),
 also swap names.get(i) with names.get(j) in the same step — this keeps both lists aligned. Use marks.set(i, marks.get(j))
 and same for names.

Collections.sort(): Collections.sort(marks) sorts ascending. For descending — Collections.sort(marks,
Collections.reverseOrder()). But this won't sync names — that's why manual sort or sorting objects (problem #7) is better
for real use.

Binary search: Collections.binarySearch(marks, 88) — list MUST be sorted ascending first. Returns index if found,
negative number if not found. Import java.util.Collections.

Key insight: Parallel ArrayLists break easily when sorting. This naturally motivates creating a Student class
(ArrayList of objects) in problem #7.
 */
/*
Dynamic student list

Ask the user how many students they want to add — but here is the twist — let them keep adding more students AFTER
that without any error. Then print all names. Do the same with a normal array and show why it fails when size grows.
This problem proves why ArrayList exists.

Enter students: 3 → Raj, Sara, Ali
Add more? (y/n): y → John
Add more? (y/n): y → Priya
Final list: [Raj, Sara, Ali, John, Priya]
Array attempt: ArrayIndexOutOfBoundsException at index 3 ← WHY ArrayList

Skills: add(), do-while, dynamic growth vs fixed array, ArrayIndexOutOfBoundsException

 */


package ArrayList;
import java.util.ArrayList;
import java.util.Scanner;
public class DynamicStudentList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> studentList = new ArrayList<>();
        System.out.println("================ Using ArrayList =====================");
        System.out.print("Enter how many student want to add: ");
        int num = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < num; i++){
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            studentList.add(name);
        }

        boolean addNew ;

        do{
            System.out.print("Add more? (y/n): ");
            addNew = sc.nextLine().equalsIgnoreCase("y");
            if(addNew){
                System.out.print("Enter student name: ");
                String name = sc.nextLine();
                studentList.add(name);
            }

        } while (addNew);

        System.out.println("Final List: "+studentList);

        System.out.println("================ Using Array =====================");
        String[] list = new String[3];
        list[0] = "Raj Kumar";
        list[1] = "Raghav Sharma";
        list[2] = "Kapil Sharma";

        System.out.println("Array filled with 3 students. Now trying to add 4th student...");
        try {
            list[3] = "Kumar Verma";
            System.out.println("Student added successfully");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e+ " This is why we use ArrayList — it grows automatically");
        }



    }
}

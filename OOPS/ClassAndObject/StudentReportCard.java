package ClassAndObject;

/*
Student report card

Create a Student class with name, rollNo, and marks for 3 subjects.
Write a method to calculate total, percentage, and grade.
Create 2 student objects and print both report cards.

Class: Student { name, rollNo, marks[3], calcTotal(), calcPercent(), getGrade() }
Output: Name: Raj | Roll: 101 | Total: 240/300 | 80% | Grade: B

Skills Required to solve this problem : class, object, fields, methods, dot operator, constructor

=================================== Hint is Present at the bottom of this page ===================================
 */

import java.util.Scanner;

public class StudentReportCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//      ----------------------- Student 1 Report ---------------------------
        System.out.println("--- Enter details for Student 1 ---");
        Student s1 = new Student("Raj", 101);
        System.out.println("Enter marks for 3 subjects (out of 100):");
        for(int i = 0; i < s1.marks.length; i++){
            System.out.print("Subject " + (i + 1) + " : ");
            s1.marks[i] = sc.nextInt();
            if(s1.marks[i] > 100){
                System.out.println("Please enter valid marks (out of 100)! Not greater than 100");
                return;
            }
            if(s1.marks[i] < 0){
                System.out.println("Please enter valid marks (out of 100)! Negative not allowed");
                return;
            }

        }
        s1.printReport();
        System.out.println("-------------------------------------------------------------");


//      ----------------------- Student 2 Report ---------------------------
        System.out.println("--- Enter details for Student 2 ---");
        Student s2 = new Student("Raghav", 102);
        System.out.println("Enter marks for 3 subjects (out of 100):");
        for(int i = 0; i < s2.marks.length; i++){
            System.out.print("Subject " + (i + 1) + " : ");
            s2.marks[i] = sc.nextInt();
        }
        s2.printReport();

    }
}


class Student{
    String name;
    int rollNo;
    int[] marks = new int[3];


    // Constructor
    Student(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    public int calcTotal(){
        return marks[0]+marks[1]+marks[2];
    }

    public double calcPercent(){
        double value = (double) (calcTotal() * 100) / 300;
        return Math.round(value * 100.0) / 100.0;
    }

    public char getGrade(){
        double percentage = calcPercent();
        if(percentage >= 90){
            return 'A';
        } else if (percentage >= 80){
            return 'B';
        } else if (percentage >= 70){
            return 'C';
        } else if (percentage >= 60){
            return 'D';
        } else {
            return 'F';
        }

    }

    public void printReport(){
        System.out.println("Name: "+name+" | RollNo: "+rollNo+" | Total: "+calcTotal()+"/300 | "+calcPercent()+"% | "+"Grade: "+getGrade());
    }

}











/*
Hint :
Create the Student class in a separate block with fields and methods.
In main(), use new Student() to create objects, set values using dot operator (s1.name = "Raj"),
then call methods on each object. Grade logic — A:>=90, B:>=80, C:>=70, D:>=60, F:below 60.
 */

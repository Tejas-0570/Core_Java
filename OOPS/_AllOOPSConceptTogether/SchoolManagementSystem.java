/*
School management system

Interface Gradable with calculateGrade(). Abstract class Person (name, id).
Student extends Person, implements Gradable — has marks[], calculates grade.
Teacher extends Person — has subject, salary, rateTeacher() method.
School class manages Student[] and Teacher[] with search  methods.

School: addStudent(), addTeacher(), findStudent(id), findTeacher(id)
Teacher: rateTeacher() → "Mr. Kumar rated 5 stars for Math"

Skills: manager class pattern, multiple arrays, search by id, statistics across objects

 */

package _AllOOPSConceptTogether;
public class SchoolManagementSystem {
    public static void main(String[] args) {
        School sc = new School();
        Student st1 = new Student("Tejas", 101, new int[]{45,56,77,88,67});
        Student st2 = new Student("Yash", 102, new int[]{40,51,57,95,90});
        Student st3 = new Student("Pravin", 103, new int[]{35,66,97,81,62});
        Student st4 = new Student("Ranveer", 104, new int[]{90,47,71,70,64});
        Teacher t1 = new Teacher("Mr. Jare", 901, "Mathematics", 75000);
        Teacher t2 = new Teacher("Mr. Kulkarni", 902, "Mechanics", 90000);
        Teacher t3 = new Teacher("Mr. Haridas", 903, "Physics", 70000);
        Teacher t4 = new Teacher("Mr. Bhosale", 904, "C Programming", 50000);

        sc.addStudent(st1);
        sc.addStudent(st2);
        sc.addStudent(st3);
        sc.addStudent(st4);
        sc.findStudent(101);
        sc.findStudent(102);
        sc.findStudent(111);
        sc.findStudent(104);
        sc.addTeacher(t1);
        sc.addTeacher(t2);
        sc.addTeacher(t3);
        sc.addTeacher(t4);
        sc.findTeacher(901);
        sc.findTeacher(902);
        sc.findTeacher(933);
        sc.findTeacher(904);
        t1.rateTeacher(5);
    }
}

interface Gradable{
    char calculateGrade();
}

abstract class person{
    private String name;
    private int id;
    person(String name, int id){
        this.name = name;
        this.id = id;
    }

//  ----------- Getters ----------------
    public String getName(){ return name; }
    public int getId(){ return id; }

}

class Student extends person implements Gradable{
    private int[] marks;
    Student(String name, int id, int[] marks){
        super(name, id);
        this.marks = marks;
    }
    public int[] getMarks(){
        return marks;
    }
    @Override
    public char calculateGrade(){
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return ((double)total/marks.length > 90 ? 'A': ((double)total/marks.length > 80 ? 'B': ((double)total/marks.length > 70 ? 'C': 'D')));
    }
}

class Teacher extends person{
    String subject;
    int salary;
    Teacher(String name, int id, String subject, int salary){
        super(name, id);
        this.subject = subject;
        this.salary = salary;
    }

    public void rateTeacher(int rating){
        System.out.println(getName()+" rated "+rating+" star for "+subject);
    }
}

class School{
    private static final int MAX = 10;
    Student[] students = new Student[MAX];
    Teacher[] teachers = new Teacher[MAX];
    int studentCount = 0;
    int teacherCount = 0;

    public void addStudent(Student student){
        if(studentCount < MAX){
            students[studentCount] = student;
            studentCount++;
            System.out.println("Student Added Successfully!");
        } else {
            System.out.println("Admission are full! Can't add new student");
        }
    }

    public void addTeacher(Teacher teacher){
        if(teacherCount < MAX){
            teachers[teacherCount] = teacher;
            teacherCount++;
            System.out.println("Teacher Added Successfully!");
        } else {
            System.out.println("Teacher vacancies are full! Can't add new teacher");
        }
    }

    public void findStudent(int id){
        for(int i = 0; i < studentCount; i++){
            if(students[i].getId() == id){
                System.out.println("Name: "+students[i].getName()+" | ID: "+students[i].getId()+" | Grade: "+students[i].calculateGrade());
                return;
            }
        }
        System.out.println("Student not found");
    }

    public void findTeacher(int id){
        for(int i = 0; i < teacherCount; i++){
            if(teachers[i].getId() == id){
                System.out.println("Name: "+teachers[i].getName()+" | ID: "+teachers[i].getId()+" | Subject: "+teachers[i].subject+" | Salary: "+teachers[i].salary);
                return;
            }
        }
        System.out.println("Teacher not found");
    }

    public void showSummary(){
        System.out.println("----------------------- School Summary ---------------------------");
        System.out.println("Total Student: "+studentCount);
        if(studentCount == 0){
            System.out.println("No students are enrolled");
            return;
        }

        double totalOfAverages = 0;
        Student top = students[0];
        double topAvg = averageOf(students[0]);

        for(int i = 0; i < studentCount; i++){
            double avg = averageOf(students[i]);
            totalOfAverages += avg;

            if(avg > topAvg){
                topAvg = avg;
                top = students[i];
            }
        }

        System.out.println("Top Scorer: " + top.getName() + " (Avg: " + topAvg + ")");
        System.out.println("Overall Average Marks: " + (totalOfAverages / studentCount));
    }


    private double averageOf(Student s){
        int total = 0;
        for(int mark : s.getMarks()){
            total += mark;
        }
        return (double) total / s.getMarks().length;
    }

}
/*
Student with getters and setters

Create a Student class where all fields (name, age, marks) are private.
Provide getters and setters for each. In the setter for age, reject values below 5 or above 25.
In the setter for marks, reject values below 0 or above 100.

setAge(17) → accepted
setAge(2) → "Invalid age"
setMarks(110)→ "Marks out of range"

Skills: private fields, getters, setters, this keyword, validation
*/

package Encapsulation;
public class StudentWithGettersAndSetters {
    public static void main(String[] args) {
        Student st = new Student();
        System.out.println("-------------- Setter --------------------");
        st.setName("Tejas");
        st.setAge(20);
        st.setMarks(100);

        System.out.println("-------------- Getter --------------------");
        System.out.println("Name: "+st.getName());
        System.out.println("Age: "+st.getAge());
        System.out.println("Marks: "+st.getMarks());

    }
}

class Student{
    private String name;
    private int age;
    private int marks;

//  -------------- Getters --------------
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getMarks(){
        return marks;
    }

//  -------------- Setters --------------
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        if(age >= 5 && age <= 25){
            this.age = age;
            System.out.println("Age Accepted");
        } else {
            System.out.println("Invalid Age");
        }

    }

    public void setMarks(int marks){
        if(marks >= 0 && marks <= 100){
            this.marks = marks;
            System.out.println("Marks Accepted");
        } else {
            System.out.println("Marks out of range");
        }
    }
}

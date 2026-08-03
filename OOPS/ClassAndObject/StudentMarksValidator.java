/*
Student marks validator

Create a Student class with private name and marks array of 5 subjects.
Setter for each mark must reject values below 0 or above 100. Methods:
calcAverage(), getHighest(), getLowest(), displayReport().

setMark(0, 105) → "Invalid mark — must be 0 to 100"
setMark(0, 85) → accepted
Average: 78.4 | Highest: 92 | Lowest: 61
 */


package ClassAndObject;
public class StudentMarksValidator {
    public static void main(String[] args) {
        student st = new student("Tejas", 5);
        st.setMarks(0, 70);
        st.setMarks(1, 85);
        st.setMarks(2, 45);
        st.setMarks(3, 66);
        st.setMarks(4, 78);

        st.displayReport();

    }
}

class student{
    private String name;
    private int[] marks;

    student(String name, int size){
        this.name = name;
        marks = new int[size];

    }

//  ----------------- Setters -----------------
    public void setMarks(int index, int mark){
        if(mark < 0 || mark > 100){
            System.out.println("Invalid mark - must be 0 to 100");
        } else {
            marks[index] = mark;
        }
    }

//  ----------------- Concrete Methods -----------------
    public float calcAverage(){
        float avg = 0;
        for(int i = 0; i < marks.length; i++){
            avg += marks[i];
        }
        return avg/marks.length;
    }
    public int getHighest(){
        int highest = Integer.MIN_VALUE;
        for(int i = 0; i < marks.length; i++){
            if(marks[i] > highest){
                highest = marks[i];
            }
        }
        return highest;
    }
    public int getLowest(){
        int lowest = Integer.MAX_VALUE;
        for(int i = 0; i < marks.length; i++){
            if(marks[i] < lowest){
                lowest = marks[i];
            }
        }
        return lowest;
    }
    public void displayReport(){
        System.out.println("Name: "+name+" | Average: "+calcAverage()+" | Highest: "+getHighest()+" | Lowest: "+getLowest());
    }
}

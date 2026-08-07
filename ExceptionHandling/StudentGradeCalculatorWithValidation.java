/*
Student grade calculator with validation

Create a custom unchecked exception InvalidMarksException. Write setMarks(int marks) that throws it for values outside 0-100.
Write calcGrade() that throws ArithmeticException if no marks are set (marks = -1 default).
Chain exceptions — catch one and throw another with original as cause.

setMarks(110) → throws InvalidMarksException: "110 invalid"
calcGrade() → throws ArithmeticException: "Marks not set"
getCause() → shows original exception that triggered it

Skills: unchecked exception, RuntimeException, exception chaining, getCause(), initCause()

 */


public class StudentGradeCalculatorWithValidation {
    int marks = -1;
    public static void main(String[] args) {
        StudentGradeCalculatorWithValidation s = new StudentGradeCalculatorWithValidation();
        try{
            s.setMarks(110);
        } catch (InvalidMarksException e){
            System.out.println("Caught: "+e.getMessage());
        }

        try{
            s.calcGrade();
        } catch (ArithmeticException e){
            System.out.println("Caught: "+e.getMessage());
            System.out.println("Caught by: "+e.getCause());
        }

        s.setMarks(85);
        s.calcGrade();
    }

    public void setMarks(int marks){
        if(marks < 0 || marks > 100){
            throw new InvalidMarksException(marks+" Invalid");
        }
        this.marks = marks;
        System.out.println("Marks set successfully");
    }

    public  void calcGrade(){
        try{
            if(marks == -1){
                throw new ArithmeticException("No valid marks were ever set");
            }
            System.out.println(marks > 90 ? "Grade: A": (marks > 80 ? "Grade: B": (marks > 70 ? "Grade: C": "Grade: D")));
        } catch (ArithmeticException original) {
            ArithmeticException wrapped = new ArithmeticException("Marks not set");
            wrapped.initCause(original);
            throw wrapped;
        }

    }

}

class InvalidMarksException extends RuntimeException{
    InvalidMarksException(String msg){
        super(msg);
    }
}

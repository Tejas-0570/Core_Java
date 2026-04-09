public class StaticBlockEx1 {

    static {
        System.out.println("From Static Block 1");
    }
    static {
        System.out.println("From Static Block 2");
    }

    public static void main(String[] args) {
        System.out.println("From Main Method");
    }

    static {
        System.out.println("From Static Block 3");
    }
}

/*
Output :
From Static Block 1
From Static Block 2
From Static Block 3
From Main Method

Before the actual execution start static blocks get executed/ OR
During class loading process static blocks gets executed
(class loading process done before actual execution. Actual execution start from main() method)

Definition :
In Java, a static block (also known as a static initialization block)
is a block of code enclosed in curly braces and preceded by the static keyword.
It is used primarily for the one-time initialization of static variables or to
perform complex setup tasks when a class is first loaded into memory

NOTE :
1) A static block does not have any name
2) A static block does not have any return type
3) A static block cannot accept any formal arguments
4) A static block cannot have access modifier.
5) All static block first get execute in top-to-bottom order and then main() method execution starts (Actual Execution)
 */

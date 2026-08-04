/*
Smart printer (overloading)

Create a Printer class with overloaded print() method — print(String text) for plain text, print(String text, int copies)
for multiple copies, print(String text, String color) for colored print, print(String text, int copies, String color) for both.

print("Hello") → Printing: Hello
print("Hello", 3) → Printing 3 copies: Hello
print("Hello", "red") → Printing in red: Hello
print("Hello", 3, "blue") → Printing 3 copies in blue: Hello

Skills: method overloading, 4 signatures, type-based differentiation

 */

package Polymorphism;
public class SmartPrinter {
    public static void main(String[] args) {
        Printer p = new Printer();
        p.print("Hello");
        p.print("Hello", 3);
        p.print("Hello", "Red");
        p.print("Hello",3 , "Blue");
    }
}

class Printer{
    public void print(String text){
        System.out.println("Printing: "+text);
    }

    public void print(String text, int copies){
        System.out.println("Printing "+copies+" copies: "+text);
    }

    public void print(String text, String color){
        System.out.println("Printing in "+color+": "+text);
    }

    public void print(String text, int copies, String color){
        System.out.println("Printing "+copies+" copies in "+color+": "+text);
    }

}
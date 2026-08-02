/*
Rectangle calculator

Create a Rectangle class with private length and width. Write methods area(), perimeter(),
isSquare() (returns true if length == width), and displayInfo(). Create 3 rectangle objects with different dimensions.

Rect 1: length=5, width=5 → area=25, perimeter=20, isSquare=true
Rect 2: length=4, width=7 → area=28, perimeter=22, isSquare=false

Skills: constructor, private fields, boolean return, method calling method

 */


package ClassAndObject;
public class RectangleCalculator {
    public static void main(String[] args) {
        System.out.println("---------------------- Rectangle 1 Info -----------------------");
        Rectangle rect1 = new Rectangle(5, 5);
        rect1.displayInfo();
        System.out.println("---------------------- Rectangle 2 Info -----------------------");
        Rectangle rect2 = new Rectangle(7, 3);
        rect2.displayInfo();
        System.out.println("---------------------- Rectangle 3 Info -----------------------");
        Rectangle rect3 = new Rectangle(2, 8);
        rect3.displayInfo();

    }
}

class Rectangle{
    private int length;
    private int width;

    Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }

    int area(){
        return length * width;
    }

    int perimeter(){
        return 2 * (length + width);
    }

    boolean isSquare(){
        return length == width;
    }

    void displayInfo(){
        System.out.println("Length: "+length+" | Width: "+width+" | Area: "+area()+" | Perimeter: "+perimeter()+" | Is Square: "+isSquare());
    }
}

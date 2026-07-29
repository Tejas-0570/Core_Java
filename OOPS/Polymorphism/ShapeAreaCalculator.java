/*
Shape area calculator (overloading)

Create a Calculator class with overloaded method calcArea() — one version takes one double (circle),
one takes two doubles (rectangle), one takes base and height (triangle). Same method name, different parameters.

calcArea(7) → Circle area = 153.93
calcArea(4, 6) → Rectangle area = 24.0
calcArea(5, 8) → Triangle area = 20.0
 */


package Polymorphism;
public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.printf("Circle Area = %.2f%n", c.calcArea(7));
        System.out.printf("Rectangle Area = %.2f%n", c.calcArea(4, 6));
        System.out.printf("Triangle Area = %.2f%n", c.calcArea(5, 8, "triangle"));
    }
}


class Calculator{

    double calcArea(double radius){
        return Math.PI * radius * radius;
    }

    double calcArea(double length, double width){
        return length * width;
    }

    double calcArea(int base, int height, String shape){
        if(shape.equalsIgnoreCase("Triangle")){
            return (double)(base*height)/2;
        }
        return 0;
    }
}

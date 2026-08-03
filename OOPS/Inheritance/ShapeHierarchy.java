/*
Shape hierarchy

Create parent class Shape with color and name fields. Child classes Circle (radius), Rectangle (length, width),
Triangle (base, height) each extend Shape. Each has calcArea() and displayInfo() that prints name, color and area.

Circle: color=red, radius=7 → area=153.94
Rectangle:color=blue, 4x6 → area=24.0
Triangle: color=green, base=5, h=8 → area=20.0
 */


package Inheritance;
public class ShapeHierarchy {
    public static void main(String[] args) {
        Shape[] s = new Shape[3];
        s[0] = new Circle("red", "Circle", 7);
        s[1] = new Rectangle("blue", "Rectangle", 4,6);
        s[2] = new Triangle("green", "Triangle",5,8);

        for(Shape shape : s){
            shape.displayInfo();
        }


    }
}

abstract class Shape{
    protected String color;
    protected String name;
    Shape(String color, String name){
        this.color = color;
        this.name = name;
    }
    public abstract double calcArea();
    public abstract void displayInfo();
}

class Circle extends Shape{
    private double radius;
    Circle(String color, String name, double radius){
         super(color, name);
         this.radius = radius;
    }

    @Override
    public double calcArea(){
        return Math.PI * radius * radius;
    }
    @Override
    public void displayInfo(){
        System.out.println("Name: "+super.name+" | Color: "+super.color+" | Area: "+calcArea());
    }
}

class Rectangle extends Shape{
    private double length;
    private double width;
    Rectangle(String color, String name, int length, int width){
        super(color, name);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calcArea(){
        return length * width;
    }
    @Override
    public void displayInfo(){
        System.out.println("Name: "+super.name+" | Color: "+super.color+" | Area: "+calcArea());
    }
}

class Triangle extends Shape{
    private double base;
    private double height;
    Triangle(String color, String name, double base, double height){
        super(color, name);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calcArea(){
        return (base * height)/2;
    }
    @Override
    public void displayInfo(){
        System.out.println("Name: "+super.name+" | Color: "+super.color+" | Area: "+calcArea());
    }
}
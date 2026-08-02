/*
------------------------------------------------------------------------------------------------------------------------
Inheritance + Polymorphism + Encapsulation
------------------------------------------------------------------------------------------------------------------------
Online food ordering system

Abstract class FoodItem — private name and price with getters, abstract method prepareFood().
Subclasses Pizza, Burger, Pasta override prepareFood(). Create an Order class that holds array of FoodItem,
calculates total bill, and prints itemized receipt.

Order Pizza(250) + Burger(150) + Pasta(180)
Receipt Pizza - ₹250 | Burger - ₹150 | Pasta - ₹180
Total ₹580

Skills: abstract class, inheritance, encapsulation, polymorphism, array of objects, receipt generation


 */


package _AllOOPSConceptTogether;
public class OnlineFoodOrderingSystem {
    public static void main(String[] args) {
        Order order1 = new Order(3);
        order1.addItem(new Pizza("Pizza", 250));
        order1.addItem(new Burger("Burger", 150));
        order1.addItem(new Pasta("Pasta", 180));
        order1.printReceipt();
    }
}

abstract class FoodItem{
    private final String name;
    private final int price;

    FoodItem(String name, int price){
        this.name = name;
        this.price = price;
    }

//  ---------------- Getters ----------------
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }

//  ---------------- Abstract Methods ----------------
    abstract void prepareFood();
}


class Pizza extends FoodItem{

    Pizza(String name, int price){
        super(name, price);
    }

    @Override
    public void prepareFood(){
        System.out.println("Preparing Pizza");
    }
}

class Burger extends FoodItem{
    Burger(String name, int price){
        super(name, price);
    }
    @Override
    public void prepareFood(){
        System.out.println("Preparing Burger");
    }
}

class Pasta extends FoodItem{
    Pasta(String name, int price){
        super(name, price);
    }
    @Override
    public void prepareFood(){
        System.out.println("Preparing Burger");
    }
}

class Order{
    private final FoodItem[] foodItems;
    private int count;

    public Order(int size){
        foodItems = new FoodItem[size];
        count = 0;
    }

    public void addItem(FoodItem foodItem){
        foodItems[count] = foodItem;
        count++;
    }

    public double calcTotal(){
        double total = 0;
        for(int i = 0; i < count; i++){
            total += foodItems[i].getPrice();
        }
        return total;
    }

    public void printReceipt(){
        System.out.println("-------------- Order --------------");
        for(int i = 0; i < count; i++){
            System.out.println(foodItems[i].getName()+": ₹"+foodItems[i].getPrice());
        }
        System.out.println("Total: ₹"+calcTotal());
    }

}


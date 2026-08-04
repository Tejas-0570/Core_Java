/*
Online store product hierarchy

Abstract base Product with private name, price, and stock. Methods addStock(), sellItem() (reduce stock by 1, reject if 0),
displayInfo(). Child classes Electronics (adds warranty in months) and Clothing (adds size) extend Product differently.

Electronics: Laptop ₹75000, stock=2, warranty=12 months
sellItem() → "Sold: Laptop | Remaining: 1"
sellItem()×3 → "Out of stock: Laptop"

Skills: abstract class, shared concrete methods, super.method(), stock guard

 */

package Inheritance;
public class OnlineStoreProductHierarchy {
    public static void main(String[] args) {
        Electronics e = new Electronics("Laptop", 75000, 10, 12);
        e.addStock(10);
        e.displayInfo();
        e.sellItem();
        e.displayInfo();

        System.out.println("-----------------------------------------------------------------------------");

        Cloths c = new Cloths("US Polo Shirt", 2999, 10, "XL");
        c.addStock(5);
        c.displayInfo();
        c.sellItem();
        c.displayInfo();
    }
}

abstract class Product {
    private String name;
    private int price;
    private int stock;

    Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }


    public void addStock(int stock) {
        if (stock > 0) {
            this.stock += stock;
            System.out.println("Stock added successfully");
        } else {
            System.out.println("Invalid Number");
        }
    }

    public void sellItem() {
        if(this.stock <= 0){
            System.out.println("Out of stock: "+this.name);
        } else {
            this.stock -= 1;
            System.out.println("Sold: "+this.name+" | Remaining: "+this.stock);
        }
    }
    public void displayInfo(){
        System.out.println("Name of Product: "+getName()+" | Price: "+getPrice()+" | Stock: "+getStock());
    }
}
class Electronics extends Product{
    int warranty;
    Electronics(String name, int price, int stock, int warranty){
        super(name, price, stock);
        this.warranty = warranty;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Warranty: "+warranty);
    }
}

class Cloths extends Product{
    String size;
    Cloths(String name, int price, int stock, String size){
        super(name, price, stock);
        this.size = size;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Size: "+size);
    }
}
/*
E-commerce cart system

Interface Discountable with applyDiscount(double percent). Abstract class Product (name, price, category).
PhysicalProduct (adds weight, shippingCost()) and DigitalProduct (adds fileSize, shippingCost()=0) extend it.
Cart class holds Product[], with addItem(), removeItem(name), totalBill() applying discounts, and printReceipt().

Cart: add Laptop(75000) + Java eBook(499) + Headphones(2999)
Discount: 10% on Laptop → ₹67500
Receipt: itemized list + shipping per item + grand total

Skills: interface + abstract class + inheritance together, polymorphic method dispatch, Cart as manager class, receipt generation

 */

package _AllOOPSConceptTogether;
public class EcommerceCartSystem {
    public static void main(String[] args) {
        Cart c = new Cart();
        PhysicalProduct pl1 = new PhysicalProduct("Laptop", 75000, "Electronics", 2);
        PhysicalProduct pl2 = new PhysicalProduct("Mobile", 75000, "Electronics", 1);
        DigitalProduct dp1 = new DigitalProduct("Java eBook", 499, "Book", 2);
        DigitalProduct dp2 = new DigitalProduct("Python eBook", 399, "Book", 2);

        c.addItem(pl1);
        c.addItem(pl2);
        c.addItem(dp1);
        c.addItem(dp2);

        c.removeItem("Laptop");

        c.totalBill();
        c.printReceipt();

    }
}

interface Discountable {
    void applyDiscount(double percent);
}

abstract class Product implements Discountable {
    private String name;
    private double price;
    private String category;

    Product(String name, double price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public abstract double shippingCost();

    public void applyDiscount(double percent){
        price = price - (price * percent / 100);
    }


    //  --------------- Getters --------------------
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getCategory(){
        return category;
    }

}

class PhysicalProduct extends Product {
    private double weight;
    PhysicalProduct(String name, double price, String category, int weight){
        super(name, price, category);
        this.weight = weight;
    }
    @Override
    public double shippingCost(){
        return weight * 50;
    }
}

class DigitalProduct extends Product{
    private int fileSize;
    DigitalProduct(String name, double price, String category, int fileSize){
        super(name, price, category);
        this.fileSize = fileSize;
    }

    @Override
    public double shippingCost(){
        return 0;
    }
}

class Cart{
    private int MAX = 5;
    Product[] products = new Product[MAX];
    int productCount = 0;

    public void addItem(Product product){
        if(productCount < MAX){
            products[productCount] = product;
            productCount++;
        } else {
            System.out.println("Space is not available! Can't add product");
        }
    }

    public void removeItem(String name){
        for(int i = 0; i < productCount; i++){
            if(products[i].getName().equalsIgnoreCase(name)){
                // shift everything after index i, one step left
                for(int j = i; j < productCount - 1; j++){
                    products[j] = products[j + 1];
                }
                products[productCount - 1] = null;  // clear the now-duplicate last slot
                productCount--;
                System.out.println(name + " removed from cart");
                return;
            }
        }
        System.out.println("Product not found: " + name);
    }

    public double totalBill(){
        double total = 0;
        for(int i = 0; i < productCount; i++){
            total += products[i].getPrice() + products[i].shippingCost();
        }
        return total;
    }

    public void printReceipt(){
        System.out.println("=============== RECEIPT ===============");
        double grandTotal = 0;

        for(int i = 0; i < productCount; i++){
            Product p = products[i];
            double lineTotal = p.getPrice() + p.shippingCost();
            grandTotal += lineTotal;

            System.out.println(p.getName() +
                    " | Price: ₹" + p.getPrice() +
                    " | Shipping: ₹" + p.shippingCost() +
                    " | Line Total: ₹" + lineTotal);
        }

        System.out.println("-----------------------------------------");
        System.out.println("Grand Total: ₹" + grandTotal);
        System.out.println("=========================================");
    }

}
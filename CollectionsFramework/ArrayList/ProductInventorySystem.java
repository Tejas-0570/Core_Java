/*
Product inventory system

Create a Product class (name, price, quantity). Store products in ArrayList<Product>. Operations: add product,
remove by name, update price, search by name, display all, total inventory value (sum of price × quantity for all products).
This shows ArrayList of custom objects — the most common real-world use.

Add: Laptop-75000-5, Phone-25000-10, Tablet-30000-3
Search "Phone": found at index 1 → Phone | ₹25000 | qty:10
Update price: Phone → ₹22000
Total value: ₹(75000×5)+(22000×10)+(30000×3) = ₹7,15,000

Skills: ArrayList<Object>, remove(int) vs remove(Object), search by field, update via reference, total calculation

 */

package ArrayList;
import java.util.ArrayList;
public class ProductInventorySystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addProduct(new Product("Laptop", 75000, 5));
        inventory.addProduct(new Product("Phone", 25000, 10));
        inventory.addProduct(new Product("Tablet", 30000, 3));

        inventory.removeByName("Tablet");
        inventory.searchByName("Phone");
        inventory.updatePrice("Phone", 20000);
        inventory.displayAll();
    }

}

class Product{
    private final String name;
    private int price;
    private int quantity;

    Product(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

//  -------------- Getters ------------------
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
//  ------------- Setters ----------------------
    public void setPrice(int price){
        this.price = price;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

//  ----------------- Concrete method ------------------
    public void display(){
        System.out.println("Name: "+name+" | Price: "+price+" | Quantity: "+quantity);
    }

}

class Inventory{
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
        System.out.println("Product added successfully");
    }

    public void removeByName(String name){
        int index = FindIndexByName(name);
        if(index == -1){
            System.out.println(name+" is not found");
            return;
        }
        products.remove(index);
        System.out.println(name+" removed successfully");
    }

    public void updatePrice(String name, int newPrice){
        Product p = FindByName(name);
        if(p == null){
            System.out.println(name+" not found");
            return;
        }
        p.setPrice(newPrice);
        System.out.println(p.getName()+" updated price is "+p.getPrice());
    }

    public void searchByName(String name){
        int index = FindIndexByName(name);
        if(index == -1){
            System.out.println(name+" not found");
            return;
        }
        Product p = products.get(index);
        System.out.println("Found at index "+index+" --> "+"Name: "+p.getName()+" | Price: "+p.getPrice()+" | Quantity: "+p.getQuantity());
    }

    public void displayAll(){
        for(Product p : products){
            p.display();
        }
    }

    public int total(){
        int total = 0;
        for(Product p : products){
            total += p.getPrice() * p.getQuantity();
        }
        return total;
    }


    public int FindIndexByName(String name){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public Product FindByName(String name){
        int index = FindIndexByName(name);
        return index == -1 ? null : products.get(index);
    }

}


/*
Setup: Create Product class with private fields, constructor, getters, setters, and a display() method.
Then ArrayList<Product> inventory = new ArrayList<>().

Search by name: Loop through inventory — if(p.getName().equals(searchName)) — return index or the Product itself.
Do NOT use inventory.contains(product) for this — contains() uses equals() which compares object references by
default (not name), unless you override equals() in Product.

Remove by name: Find the index first using loop, then inventory.remove(index) — this is remove(int index), not remove(Object).
Different method — removes by position.

Update price: Find the Product object using loop, then call product.setPrice(newPrice) — you are modifying the
object directly, not replacing it in the list. The list still holds the same reference.

Total value: Loop once — total += p.getPrice() * p.getQuantity().
 */
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
        ArrayList<Product> products = new ArrayList<>();
        Product p1 = new Product("Laptop", 75000, 5);
        Product p2 = new Product("Phone", 25000, 3);
        products.add(0, p1);
        products.add(1, p2);
    }
}

class Product{
    final String name;
    int price;
    int quantity;

    Product(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", quantity=" + quantity + "}";
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
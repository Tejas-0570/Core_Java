/*
Shopping cart manager

Build a simple shopping cart using ArrayList. Menu-driven program with options: 1) Add item, 2) Remove item by name,
3) View cart, 4) Check if item exists, 5) Total items in cart, 6) Exit. Use all core ArrayList methods — add, remove,
contains, size, get, isEmpty.

Choice 1: Enter item → "Apple" added
Choice 2: Enter item to remove → "Milk" removed / "Milk not in cart"
Choice 4: Enter item → contains("Apple") → true
Choice 5: Total items: 3

Skills: add(), remove(Object), contains(), size(), get(), isEmpty(), menu-driven, switch
Hint Present at bottom ------->
 */

package ArrayList;
import java.util.ArrayList;
import java.util.Scanner;
public class ShoppingCartManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();
        System.out.println("============================ Welcome ============================");
        while(true){
            System.out.println("---------------------- MENU -------------------------------");
            System.out.println("1. Add items\n2. Remove item by name\n3. View Cart\n4. Check if item exists\n5. Total items in cart\n6. Exit");
            System.out.print("Enter your choice (e.g. 1 for adding items): ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1: {
                    System.out.print("Add Item: ");
                    String item = sc.nextLine();
                    products.add(item);
                    System.out.println("Item added successfully");
                    break;
                }
                case 2: {
                    System.out.print("Remove Item by name: ");
                    String removeItem = sc.nextLine();
                    if(products.remove(removeItem)){
                        System.out.println("Item removed successfully");
                    } else {
                        System.out.println("Item is not in cart");
                    }
                    break;
                }
                case 3: {
                    if(products.isEmpty()){
                        System.out.println("Cart is Empty");
                        break;
                    }
                    System.out.println("------- Cart Item --------");
                    for(int i = 0; i < products.size(); i++){
                        System.out.println((i+1)+". "+products.get(i));
                    }
                    break;
                }
                case 4: {
                    if(products.isEmpty()){
                        System.out.println("Cart is Empty");
                        break;
                    }
                    System.out.print("Check item in cart: ");
                    String checkItem = sc.nextLine();
                    System.out.println(products.contains(checkItem) ? checkItem+" Item present in cart" : checkItem+" No item in cart");
                    break;
                }
                case 5: {
                    System.out.println("Total Items in cart: "+products.size());
                    break;
                }
                case 6: {
                    System.out.println("Thank you! Visit again");
                    return;
                }
                default:{
                    System.out.println("Invalid choice");
                    break;
                }
            }
        }
    }
}
/*
Hint:
Setup: ArrayList<String> cart = new ArrayList<>(). Wrap everything in a while(true) loop with a switch statement on user's choice.

Key methods to use:
— cart.add("Apple") — adds to end
— cart.remove("Milk") — removes by value, returns boolean — use this to check if it was actually in cart
— cart.contains("Apple") — returns true/false
— cart.size() — number of items
— cart.isEmpty() — true if nothing in cart
— cart.get(i) — get item at index i

Important: sc.nextLine() after sc.nextInt() for the choice — otherwise the Enter key gets consumed and next nextLine() reads
empty string. This is a very common Scanner bug.

 */

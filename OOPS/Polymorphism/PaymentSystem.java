/*
Payment system (overriding)

Create a Payment base class with method pay(double amount).
Create UpiPayment, CardPayment, and CashPayment that override pay() differently.
Store all three in a Payment array and call pay() in a loop — each behaves differently.

payments[0].pay(500) → Paid ₹500 via UPI
payments[1].pay(500) → Paid ₹500 via Card
payments[2].pay(500) → Paid ₹500 via Cash
 */


package Polymorphism;
public class PaymentSystem {
    public static void main(String[] args) {
        Payment[] payments = new Payment[3];
        payments[0] = new UpiPayment();
        payments[1] = new CardPayment();
        payments[2] = new CashPayment();

        for(Payment p: payments){
            p.pay(500);
        }
    }
}

class Payment{
    void pay(double amount){
        System.out.printf("Paid $%.0f%n", amount);
    }
}

class UpiPayment extends Payment{
    @Override
    void pay(double amount){
        System.out.printf("Paid $%.0f via UPI%n", amount);
    }
}

class CardPayment extends Payment{
    @Override
    void pay(double amount){
        System.out.printf("Paid $%.0f via Card%n", amount);
    }
}

class CashPayment extends Payment{
    @Override
    void pay(double amount){
        System.out.printf("Paid $%.0f via Cash%n", amount);
    }
}

/*
When a base class has:

No fields that children share
No concrete methods with shared logic
Only abstract methods that every child must implement differently

That class has no reason to exist as a class — it should be an interface.
--------------------------------------------------------------------------------------
Compare side by side
// abstract class approach — what's the point of this class?
abstract class Payment {
    abstract void pay(double amount);   // no body
                                        // no shared fields
                                        // no shared logic
}                                       // this is just a contract!

// interface approach — this IS the contract
interface Payment {
    void pay(double amount);            // implicitly public abstract
}
--------------------------------------------------------------------------------------
Both achieve the same result. But interface is cleaner and more honest about what it is — a pure contract.
Interface version of Payment system
package Polymorphism;

public class PaymentSystem {
    public static void main(String[] args) {
        Payment[] payments = new Payment[3];
        payments[0] = new UpiPayment();
        payments[1] = new CardPayment();
        payments[2] = new CashPayment();

        for (Payment p : payments) {
            p.pay(500);
        }
    }
}

interface Payment {
    void pay(double amount);            // no body, no abstract keyword needed
}

class UpiPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.printf("Paid ₹%.0f via UPI%n", amount);
    }
}

class CardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.printf("Paid ₹%.0f via Card%n", amount);
    }
}

class CashPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.printf("Paid ₹%.0f via Cash%n", amount);
    }
}
--------------------------------------------------------------------------------------------
So when do you choose what
____________________________________________________________________________
Situation	                                               Use
____________________________________________________________________________
Only method contracts, no shared data or logic	           interface
Some shared fields and some shared logic, some abstract.   abstract class
Everything shared, nothing abstract	                       regular class
____________________________________________________________________________
 */
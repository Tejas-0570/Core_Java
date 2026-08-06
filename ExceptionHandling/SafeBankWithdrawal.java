/*
Safe bank withdrawal

Create a BankAccount class with withdraw(double amount). Throw an InsufficientFundsException (custom checked exception)
if balance is low. Throw IllegalArgumentException if amount is negative or zero. Handle both in main() with separate catch blocks.

withdraw(500) → "Withdrawn: ₹500 | Balance: ₹4500"
withdraw(-100) → catch IllegalArgumentException → "Invalid amount"
withdraw(9000) → catch InsufficientFundsException → "Need ₹4000 more"

Skills: custom checked exception, throws declaration, multiple catch blocks, throw keyword

 */
import java.util.Scanner;
public class SafeBankWithdrawal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        int amount = sc.nextInt();
        BankAccount ba = new BankAccount(10001, "Tejas", 10000);
        try{
            ba.withdraw(amount);
            ba.deposit(amount);
        } catch (InsufficientFundsException | IllegalArgumentException e){
            System.out.println(e);
        }


    }
}
class BankAccount {
    private final int accNo;
    private final String holderName;
    private double balance;

    BankAccount(int accNo, String holderName, double balance){
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
    }

//  -------------------- Getters --------------------
    public int getAccNo(){
        return accNo;
    }
    public String getHolderName(){
        return holderName;
    }
    public double getBalance(){
        return balance;
    }

//  ------------------ Setters ------------------------
    public void setBalance(double balance){
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount < 0){
            System.out.println("Invalid amount! Amount must be positive");
            return;
        }
        setBalance(getBalance()+amount);
        System.out.println("Amount deposited successfully! Avl. Bal. : "+getBalance());
    }

    public void withdraw(double amount) {
        if(amount < 0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        if(getBalance() < amount){
            throw new InsufficientFundsException("Insufficient Funds");
        }
        setBalance(getBalance() - amount);
        System.out.println("Amount withdraw successfully! Avl. Bal. : "+getBalance());
    }
}

class InsufficientFundsException extends RuntimeException{
    InsufficientFundsException(String msg){
        super(msg);
    }
}

class IllegalArgumentException extends RuntimeException{
    IllegalArgumentException(String msg){
        super(msg);
    }
}

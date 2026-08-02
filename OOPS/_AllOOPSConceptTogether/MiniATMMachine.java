/*
------------------------------------------------------------------------------------------------------------------------
All 5 pillars
------------------------------------------------------------------------------------------------------------------------
Mini ATM machine

Interface Transactable with deposit() and withdraw(). Abstract class Account implements it — private accountNo, holderName,
balance with getters. SavingsAccount (min balance 1000, no interest below it) and CurrentAccount (overdraft up to 5000 allowed)
extend Account differently.

Savings withdraw(9500) with balance 10000 → allowed, balance=500 blocked (min 1000)
Current withdraw(3000) with balance 0 → allowed up to 5000 overdraft

Skills: interface, abstract class, inheritance, encapsulation, polymorphism, business rules

 */


package _AllOOPSConceptTogether;
public class MiniATMMachine {
    public static void main(String[] args) {
        SavingsAccount sv = new SavingsAccount(10001, "Tejas");
        sv.deposit(10000);
        sv.withdraw(9000);
        sv.displayAccountInfo();

        CurrentAccount cv = new CurrentAccount(10002, "Navin");
        cv.deposit(1000);
        cv.withdraw(500);
        cv.withdraw(500);
        cv.deposit(1000);
        cv.withdraw(500);
        cv.withdraw(4000);
        cv.deposit(1000);
        cv.withdraw(4000);
        cv.withdraw(500);

        cv.displayAccountInfo();

    }
}

interface Transactable{
    void deposit(double amount);
    void withdraw(double amount);
}

abstract class Account{
    private final long accountNo;
    private final String holderName;
    private double balance;

    public Account(long accountNo, String holderName){
        this.accountNo = accountNo;
        this.holderName = holderName;
        balance = 0;
    }

//  ---------------- Getters -------------------
    public long getAccountNo(){
        return accountNo;
    }
    public String getHolderName(){
        return holderName;
    }
    public double getBalance(){
        return balance;
    }

//  ---------------- Setters -------------------
    public void setBalance(double balance){
        this.balance = balance;
    }

}

class SavingsAccount extends Account implements Transactable{

    public SavingsAccount(long accountNo, String holderName) {
        super(accountNo, holderName);
    }

    @Override
    public void deposit(double amount){
        System.out.println("-------------------- Deposit Section -------------------------");
        if(amount < 0){
            System.out.println("Invalid amount to deposit! Amount must be greater than 0");
            return;
        }
        setBalance(getBalance()+amount);
        System.out.println("Deposit Successfully! 🎉🎉 Available Balance: "+getBalance());
    }

    @Override
    public void withdraw(double amount){
        System.out.println("-------------------------- Withdraw Section --------------------------");
        if(getBalance() < amount){
            System.out.println("Insufficient Balance!");
            return;
        } //9500
        if(getBalance() > amount && (getBalance() - amount) < 1000){
            setBalance(getBalance() - amount);
            System.out.println("Withdraw Successfully! But NO interest because current balance is less than 1000! Avl. Bal. = "+getBalance());
            return;
        }
        setBalance(getBalance() - amount);
        System.out.println("Withdraw Successfully! Avl. Bal. = "+getBalance());
    }

    public void displayAccountInfo(){
        System.out.println("----------------------- Account Information Section-------------------------");
        System.out.println("Account No: "+getAccountNo());
        System.out.println("Account Holder: "+getHolderName());
        System.out.println("Available Balance: "+getBalance());
    }
}

class CurrentAccount extends Account implements Transactable{
    public CurrentAccount(long accountNo, String holderName){
        super(accountNo, holderName);
    }

    @Override
    public void deposit(double amount){
        System.out.println("-------------------- Deposit Section -----------------------");
        if(amount < 0){
            System.out.println("Invalid amount to deposit! Amount must be greater than 0");
            return;
        }
        setBalance(getBalance()+amount);
        if(getBalance() < 0){
            System.out.println("Deposit Successfully! 🎉🎉 Available Balance: 0"+" | Overdraft Amount: "+Math.abs(getBalance()));
        } else {
            System.out.println("Deposit Successfully! 🎉🎉 Available Balance: "+getBalance());
        }

    }

    @Override
    public void withdraw(double amount){ // 6000
        System.out.println("---------------------- Withdraw Section -------------------------");
        if(getBalance()-amount >= -5000){
            setBalance(getBalance() - amount);
            if(getBalance() < 0){
                System.out.println("Withdraw Successfully! Available Balance: 0 & Overdraft Amount: "+Math.abs(getBalance()));
                return;
            }
            System.out.println("Withdraw Successfully! Available Balance: "+getBalance());
            return;
        }
        System.out.println("Insufficient Balance!");


    }

    public void displayAccountInfo(){
        System.out.println("----------------------- Account Information Section-------------------------");
        System.out.println("Account No: "+getAccountNo());
        System.out.println("Account Holder: "+getHolderName());
        if(getBalance() < 0){
            System.out.println("Available Balance: 0 & Overdraft Amount: "+Math.abs(getBalance()));
        } else {
            System.out.println("Available Balance: "+getBalance());
        }
    }
}
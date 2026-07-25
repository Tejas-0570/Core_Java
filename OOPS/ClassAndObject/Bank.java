/*
Bank account

Create a Bank class with accountNo, holderName, and balance.
Write methods deposit(amount), withdraw(amount), and showBalance().
Withdraw should print "Insufficient funds" if balance is low.

Input: deposit(5000) → withdraw(2000) → withdraw(9000)
Output: Balance: 3000 | Insufficient funds

Skills: class, methods, void vs return, object state, if-else
 */

package ClassAndObject;
public class Bank {
    public static void main(String[] args) {
        BankAccount  b = new BankAccount(101, "Rajiv");
        b.deposit(5000);
        b.withdraw(2000);
        b.withdraw(9000);
        b.showBalance();
    }
}


class BankAccount{
    private final int accountNo;
    private final String holderName;
    private long balance;

    BankAccount(int accountNo, String holderName){
        this.accountNo = accountNo;
        this.holderName = holderName;
        this.balance = 0;
    }

    void deposit(long amount){
        if(amount < 0){
            System.out.println("Invalid deposit amount");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount + " | Balance: " + balance);

    }

    void withdraw(int amount){
        if(amount <= 0){
            System.out.println("Invalid deposit amount");
            return;
        }

        if(balance < amount){
            System.out.println("Withdraw: "+amount+" | Insufficient funds | Avl Balance:"+balance);
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount + " | Balance: " + balance);

    }

    void showBalance(){
        System.out.println("Account No:"+accountNo+" | Holder: "+holderName+" | Balance: "+balance);
    }

}



/*
Hint :
Methods that change state (deposit, withdraw) should be void.
Check balance >= amount before withdrawing. showBalance() just prints — no return needed.
Create one object in main and call methods in sequence to simulate transactions.
 */
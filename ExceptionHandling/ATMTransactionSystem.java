/*
ATM transaction system

Build a full ATM — custom exceptions: CardBlockedException, DailyLimitExceededException, WrongPinException
(after 3 wrong attempts block the card). All extend a base BankException.
Main method handles each differently and logs the exception type and message.

wrongPin() x3 → WrongPinException then CardBlockedException
withdraw(50000) → DailyLimitExceededException: "Limit ₹25000"
catch(BankException)→ catches all three via parent reference

Skills: exception hierarchy, abstract exception class, polymorphic catch, counter-based state, getClass().getSimpleName()

 */

public class ATMTransactionSystem {
    public static void main(String[] args) {
        BankAccounts ba = new BankAccounts(1001, "Samay", 100000, 1234);

        System.out.println("---- Scenario 1: 3 wrong PINs in a row -> blocked ----");
        try {
            ba.withdraw(1000, 2234);
        } catch (BankException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        }
        try {
            ba.withdraw(1000, 2234);
        } catch (BankException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        }
        try {
            ba.withdraw(1000, 2234);
        } catch (BankException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        }
        try {
            ba.withdraw(1000, 1234);
        } catch (BankException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        }

        ba.displayInfo();

        System.out.println("\n---- Scenario 2: fresh account, daily limit exceeded ----");
        BankAccounts ba2 = new BankAccounts(1002, "Riya", 100000, 5555);
        try {
            ba2.withdraw(50000, 5555);
        } catch (BankException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        }

        System.out.println("\n---- Scenario 3: normal successful withdrawal ----");
        try {
            ba2.withdraw(5000, 5555);
        } catch (BankException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        }

        ba2.displayInfo();
    }
}

class BankAccounts {
    private final int accNo;
    private final String holderName;
    private double balance;
    private final int pin;
    private int pinAttempts;
    private boolean isBlocked;
    private int limit;

    private static final int MAX_PIN_ATTEMPTS = 3;
    private static final int DAILY_LIMIT = 25000;

    BankAccounts(int accNo, String holderName, double balance, int pin) {
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
        this.pin = pin;
        this.pinAttempts = MAX_PIN_ATTEMPTS;
        this.isBlocked = false;
        this.limit = DAILY_LIMIT;
    }

    void withdraw(int amount, int pin) throws BankException {
        if (isBlocked) {
            throw new CardBlockedException("Card is blocked! First unblock your card");
        }

        if (this.pin != pin) {
            pinAttempts--;
            if (pinAttempts == 0) {
                isBlocked = true;
                throw new CardBlockedException("Card is blocked");
            }
            throw new WrongPinException("Invalid pin! Attempts left: " + pinAttempts);
        }

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance! Avl. Bal. : " + balance);
            return;
        }

        if (amount > limit) {
            throw new DailyLimitExceededException("Limit ₹" + DAILY_LIMIT);
        }

        pinAttempts = MAX_PIN_ATTEMPTS;
        balance -= amount;
        limit -= amount;
        System.out.println("Amount withdrawn successfully! Avl. Bal. : " + balance);
    }

    void displayInfo() {
        System.out.println("Name: " + holderName + " | Account No: " + accNo +
                " | Avl. Bal: " + balance + (isBlocked ? " | Card: Blocked" : ""));
    }
}

abstract class BankException extends Exception {
    BankException(String msg) {
        super(msg);
    }
}

class CardBlockedException extends BankException {
    CardBlockedException(String msg) {
        super(msg);
    }
}

class DailyLimitExceededException extends BankException {
    DailyLimitExceededException(String msg) {
        super(msg);
    }
}

class WrongPinException extends BankException {
    WrongPinException(String msg) {
        super(msg);
    }
}
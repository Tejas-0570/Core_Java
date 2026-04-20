import java.util.Scanner;

public class SmithNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid Input!");
            return;
        }

        int num = sc.nextInt();
        int temp = num;

        // Smith numbers MUST be composite
        if (isPrime(num)) {
            System.out.println(temp + " is Not a Smith Number (Primes are excluded)");
            return;
        }

        int sumOfDgt = sumOfDigit(num);
        int sumOfPrimeFact = 0;

        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                sumOfPrimeFact += sumOfDigit(i);
                num /= i;
            }
        }

        if (sumOfPrimeFact == sumOfDgt) {
            System.out.println(temp + " is a Smith Number");
        } else {
            System.out.println(temp + " is Not a Smith Number");
        }
    }

    public static int sumOfDigit(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }

    // Helper to exclude prime numbers
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

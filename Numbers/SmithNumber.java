/*
Smith Number

Composite number where:
Sum of digits = sum of digits of prime factors

Example: 666
Step 1: Check composite
666 is not prime ✔️

Step 2: Sum of digits of number
6 + 6 + 6 = 18

Step 3: Prime factorization
666 = 2 × 3 × 3 × 37

Step 4: Sum of digits of factors
2 → 2
3 → 3
3 → 3
37 → 3 + 7 = 10

Total = 2 + 3 + 3 + 10 = 18

✔️ Final Check

Sum of digits (number) = 18
Sum of digits (factors) = 18
 */

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

        // Smith numbers MUST be composite means must be divisible by any number other than 1 and itself
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

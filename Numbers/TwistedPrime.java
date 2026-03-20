/*
A twisted prime is a number that is prime, and its reverse is also a prime number.

Example:
13

13 is prime
Reverse → 31 (also prime)

✔️ So, 13 is a twisted prime
 */

//------------------ Easy and simple answer -----------------------------

import java.util.Scanner;

class TwistedPrime{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a prime number : ");
        int num = sc.nextInt();
        int revNum = 0;
        boolean isTwistedPrime = true;

        for(int i = num; i > 0; i /= 10){
            int ld = i % 10;
            revNum = revNum * 10 + ld;
        }

        for(int i = 2; i <= revNum/2; i++){
            if(revNum % i == 0){
                isTwistedPrime = false;
                break;
            }
        }

        if(isTwistedPrime){
            System.out.print(num+" is a Twisted Prime Number");
        }
        else {
            System.out.print(num+" is Not a Twisted Prime Number");
        }
    }
}




/*-------------------------------------------------------------------------------------------
Explanation :

Your Logic (n / 2)   REQUIRE 24 ITERATION TO FIND NUMBER IS PRIME OR NOT
If n = 100, your loop runs from 3 to 50. That is about 24 checks (skipping evens).

The Optimized Logic (i * i <= n) REQUIRE 10 ITERATION TO FIND NUMBER IS PRIME OR NOT
If n = 100, the loop only runs until i * i <= 100 (which is i = 10). It checks 3, 5, 7, 9. That is only 4 checks.

Why does the square root work?
Factors always come in pairs. Let’s look at n = 36 again:
2 × 18 = 36
3 × 12 = 36
4 × 9 = 36
6 × 6 = 36 (The square root)

Notice that in every pair, one number is always smaller than (or equal to) the square root, and the other is larger.
If you search all the "small" numbers and don't find a factor, it is impossible for a "large" number to exist, because it would need a "small" partner to multiply with!

Let's use your example: n = 5
Initial checks: It's not < 2, not 2, and not even.
Loop starts: i = 3.
Condition: is i * i <= n? → Is 3 × 3 <= 5? → 9 <= 5?
Result: False. The loop never even runs!
Conclusion: The method immediately returns true.

The logic is: If we couldn't find a factor by the time we hit the square root, we stop searching because there are definitely no factors left to find.

==> n / 2: Easy to understand, but slow for big numbers.
==> i * i <= n: The professional way. It's incredibly fast. For a number like 1,000,000, your way does 500,000 checks; this way does only 1,000.
------------------------------------------------------------------------------------------- */

/*

//------------------ Complex but optimized version -----------------------------
import java.util.Scanner;
class TwistedPrime{

    static int reverse(int n){
        int rev = 0;
        while(n > 0){
            rev = rev * 10 +(n%10);
            n /= 10;
        }
        return rev;
    }

    static boolean isPrime(int n){
        if(n < 2) return false;  // n=0 or n=1
        if(n == 2) return true;  // n=2
        if(n % 2 == 0) return false;  // n == even no.
        for (int i = 3; i*i <= n; i += 2){
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number : ");
        if(!sc.hasNextInt()){
            System.out.print("Invalid input. Please Enter valid integer");
            return;
        }
        int num = sc.nextInt();

        if(num < 0){
            System.out.print("Enter a positive integer");
            return;
        } // num should not be negative

        int revNum = reverse(num);

        if(isPrime(num) && isPrime(revNum)){
            System.out.print(num+" is a Twisted Prime Number");
        }
        else {
            System.out.print(num+" is Not a Twisted Prime Number");
        }

    }
}



 */
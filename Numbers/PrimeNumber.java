/*
A prime number is a number that has only two factors: 1 and itself.

Example:
7

Factors → 1 and 7

✔️ So, 7 is a prime number
 */

import java.util.Scanner;

class PrimeNumber{

    static boolean isPrime(int n){
        if(n < 2) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        for(int i = 3; i*i <= n; i += 2){
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number : ");
        if(!sc.hasNextInt()){
            System.out.print("Invalid Input! Please enter valid input");
            return;
        }
        int num = sc.nextInt();

        if(num < 0){
            System.out.print("Invalid Input! Please enter positive integer");
            return;
        }

        if(num == 0){
            System.out.print("Invalid Input! 0 can't be prime number");
            return;
        }

        if(isPrime(num)){
            System.out.print(num+" is Prime Number");
        }
        else {
            System.out.print(num+" is Not a Prime Number");
        }
    }
}
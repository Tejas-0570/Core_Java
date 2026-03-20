/*
The LCM of two or more numbers is the smallest number that is divisible by all of them.

Example:
LCM of 7 and 12

Multiples:
7 → 7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91, 98, ...
12 → 12, 24, 36, 48, 60, 72, 84, 96, 108, 120, 132, ...

✔️ Common smallest multiple = 84

So, LCM(7, 12) = 84
 */

import java.util.Scanner;
public class LCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a first number : ");
        int num1 = sc.nextInt();
        System.out.print("Enter a second number : ");
        int num2 = sc.nextInt();

        int large = num1>num2 ? num1 : num2;
        int i = 1;
        while(true){
            if((large*i) % num1 == 0 && (large*i) % num2 ==0){
                System.out.print("The LCM = "+large*i);
                break;
            }
            i++;
        }
    }
}

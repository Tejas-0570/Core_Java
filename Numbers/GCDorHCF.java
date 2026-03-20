/*
The GCD of two or more numbers is the largest number that divides all of them exactly.

Example:
Find GCD of 12 and 18

Factors:
12 → 1, 2, 3, 4, 6, 12
18 → 1, 2, 3, 6, 9, 18

✔️ Common factors → 1, 2, 3, 6
✔️ Greatest = 6

So, GCD(12, 18) = 6
 */

import java.util.Scanner;
public class GCDorHCF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a first number : ");
        int num1 = sc.nextInt();
        System.out.print("Enter a second number : ");
        int num2 = sc.nextInt();

        int small = num1<num2 ? num1 : num2;
        if(num1 % small == 0 && num2 % small == 0){
            System.out.print("GCD/HCF : "+small);
        }
        small /= 2;
        while(true){
            if(num1 % small == 0 && num2 % small == 0){
                System.out.print("GCD/HCF : "+small);
                break;
            }
            small--;
        }


    }
}

/*
Spy Number is a number where:
Sum of digits = Product of digits

✔ Example

123
Sum → 1+2+3 = 6
Product → 1×2×3 = 6 ✔

1124
Sum → 8
Product → 8 ✔

132
Sum=6
Product=6 ✔

❌ Not Spy
124 → Sum=7, Product=8 ❌
 */

import java.util.Scanner;
class SpyNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int num = sc.nextInt();
        int sum = 0, product = 1;

        for(int i = num; i > 0; i /= 10){
            int lastDigit = i % 10;
            sum += lastDigit;
            product *= lastDigit;
        }
        if(sum == product){
            System.out.print(num+" is SPY NUMBER");
        } else {
            System.out.print(num+" is NOT a SPY NUMBER");
        }
    }
}
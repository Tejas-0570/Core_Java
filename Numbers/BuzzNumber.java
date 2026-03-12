/*
Definition : The number which is divisible by 7 or having last digit 7
             e.g. 70 --> Buzz Number
                  17 --> Buzz Number
                  10 --> Not a Buzz Number (Neither divisible by 7 nor last digit 7)
 */

import java.util.Scanner;

class BuzzNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int num = sc.nextInt();

        if(num%7 == 0 || num%10 == 7){
            System.out.print("\n"+num+" is a BUZZ NUMBER");
        }
        else{
            System.out.print("\n"+num+" is  NOT a BUZZ NUMBER");
        }
    }
}
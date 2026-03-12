/*
Definition : The number which contain 0 in it except the number having 0 at start
             e.g. 1000 --> Duck Number
                  1023 --> Duck Number
                  1234 --> Not a Duck Number
                  0123 --> Not a Duck Number
*/

import java.util.Scanner;

class DuckNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int num = sc.nextInt();

        boolean isDuck = false;
        for(int i = num; i > 0; i /= 10){
            if(i % 10 == 0){
                isDuck = true;
            }
        }

        if(isDuck){
            System.out.print(num+" is a DUCK NUMBER");
        }
        else{
            System.out.print(num+" is NOT a DUCK NUMBER");
        }

    }
}